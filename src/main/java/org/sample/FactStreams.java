package org.sample;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class FactStreams {
    private static final BigInteger ONE = BigInteger.valueOf(1);

    public static BigInteger streamed(int n) {
        if(n < 2) return ONE;
        return IntStream.rangeClosed(2, n).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

    public static BigInteger streamedParallel(int n) {
        if(n < 2) return ONE;
        return IntStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

    public static BigInteger fourBlocks(int n) {
        if(n < 2) return ONE;
        BigInteger r1 = ONE, r2 = ONE, r3 = ONE, r4 = ONE;
        int i;
        for (i = n; i > 4; i -= 4)
        {
            r1 = r1.multiply(BigInteger.valueOf(i));
            r2 = r2.multiply(BigInteger.valueOf(i - 1));
            r3 = r3.multiply(BigInteger.valueOf(i - 2));
            r4 = r4.multiply(BigInteger.valueOf(i - 3));
        }
        int mult = i == 4 ? 24 : i == 3 ? 6 : i == 2 ? 2 : 1;
        return r1.multiply(r2).multiply(r3.multiply(r4)).multiply(BigInteger.valueOf(mult));
    }

    public static BigInteger streamedShift(int n) {
        if(n < 2) return ONE;
        int p = 0, c = 0;
        while ((n >> p) > 1) {
            p++;
            c += n >> p;
        }
        return IntStream.rangeClosed(2, n).map(i -> i >> Integer.numberOfTrailingZeros(i))
                .mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get().shiftLeft(c);
    }

    public static BigInteger streamedParallelShift(int n) {
        if(n < 2) return ONE;
        int p = 0, c = 0;
        while ((n >> p) > 1) {
            p++;
            c += n >> p;
        }
        return IntStream.rangeClosed(2, n).parallel().map(i -> i >> Integer.numberOfTrailingZeros(i))
                .mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get().shiftLeft(c);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long t1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        BigInteger r = forkJoinPool.submit(() -> streamedParallel(10000)).get();
        long t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);
    }
}
