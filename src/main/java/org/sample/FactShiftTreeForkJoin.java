package org.sample;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by serg on 19.02.17.
 */
public class FactShiftTreeForkJoin {

    public static ForkJoinPool sharedPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public static BigInteger fact(ForkJoinPool forkJoinPool, int n) {
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

        return forkJoinPool.invoke(new FactTask(2, n)).shiftLeft(c);
    }

    public static class FactTask extends RecursiveTask<BigInteger> {

        private int low;
        private int high;

        public FactTask(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public BigInteger compute() {
            if (high <= low) {
                return BigInteger.valueOf(low >> Integer.numberOfTrailingZeros(low));
            }

            int diff = high - low;
            if (diff == 1) {
                return BigInteger.valueOf(low >> Integer.numberOfTrailingZeros(low)).multiply(
                        BigInteger.valueOf(high >> Integer.numberOfTrailingZeros(high)));
            }

            int mid = low + (diff >>> 1);

            FactTask left = new FactTask(low, mid);
            FactTask right = new FactTask(mid + 1, high);

            left.fork();
            BigInteger rightResult = right.compute();
            BigInteger leftResult  = left.join();
            return leftResult.multiply(rightResult);
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        BigInteger r = FactShiftTreeForkJoin.fact(sharedPool, 10000);
        long t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);
    }

}
