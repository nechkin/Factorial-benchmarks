package org.sample;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by serg on 19.02.17.
 */
public class FactShiftTreeForkJoinMinSize {

    public static ForkJoinPool sharedPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public static BigInteger fact(ForkJoinPool forkJoinPool, int n) {
        return fact(forkJoinPool, n, 1);
    }

    public static BigInteger fact(ForkJoinPool forkJoinPool, int n, int minSize) {
        if (n < 0)
            return BigInteger.ZERO;
        if (n == 0)
            return BigInteger.ONE;
        if (n == 1 || n == 2)
            return BigInteger.valueOf(n);

        int p = 0, c = 0;
        while((n >> p) > 1) {
            p++;
            c += n >> p;
        }

        return forkJoinPool.invoke(new FactTask(2, n, minSize)).shiftLeft(c);
    }

    public static BigInteger naive(int low, int high) {
        BigInteger r = BigInteger.valueOf(low >> Integer.numberOfTrailingZeros(low));
        for (int i = low + 1; i <= high; ++i) {
            r = r.multiply(BigInteger.valueOf(i >> Integer.numberOfTrailingZeros(i)));
        }
        return r;
    }

    public static class FactTask extends RecursiveTask<BigInteger> {

        private int low;
        private int high;
        private int minSize;

        public FactTask(int low, int high, int minSize) {
            this.low = low;
            this.high = high;
            this.minSize = minSize;
        }

        @Override
        public BigInteger compute() {
            if (high <= low) {
                return BigInteger.valueOf(low >> Integer.numberOfTrailingZeros(low));
            }

            int diff = high - low;
            if (diff <= minSize) {
                return naive(low, high);
            }

            int mid = low + (diff >>> 1);

            FactTask left = new FactTask(low, mid, minSize);
            FactTask right = new FactTask(mid + 1, high, minSize);

            left.fork();
            BigInteger rightResult = right.compute();
            BigInteger leftResult  = left.join();
            return leftResult.multiply(rightResult);
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        BigInteger r = FactShiftTreeForkJoinMinSize.fact(sharedPool, 50000, 10);
        long t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);
    }

}
