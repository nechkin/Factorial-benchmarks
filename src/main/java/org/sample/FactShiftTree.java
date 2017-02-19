package org.sample;

import java.math.BigInteger;

/**
 * Created by serg on 20.04.15.
 */
public class FactShiftTree {

    public static BigInteger naive(int n) {
        BigInteger r = BigInteger.ONE;
        for (int i = 2; i <= n; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        return r;
    }

    public static BigInteger factShift(int n) {
        if (n < 2) return BigInteger.ONE;

        // Step 1: collect all twos from all numbers used in multiplication sequence used to compute the factorial
        // (e.g. 1 * 2 * 3 * 4 * 5 * 6. One two in 2, and two twos in 4. So [c] = 3.)
        int p = 0, c = 0;
        while((n >> p) > 1) {
            p++;
            c += n >> p;
        }

        BigInteger r = BigInteger.ONE;
        // Step 2: multiply all odd numbers, and odd portion of even numbers
        // (e.g. for 6!, 1 * 3 * 5 * 3 (3 is odd portion of 6))
        for (int i = 2; i <= n; ++i) {
            // Remove all twos from the [i]
            // (e.g. when we need to multiply by 12, multiply by 3, but do not multiply by 4)
            // (e.g. when we need to multiply by odd number, e.g. 3, multiply by 3, because 3 is not divisible by 2)
            r = r.multiply(BigInteger.valueOf(i >> Integer.numberOfTrailingZeros(i)));
        }

        // Step 3: multiply by all twos collected in step 1. (e.g. if we have 3 twos, than multiply by 2^3 = 8)
        r = r.shiftLeft(c);

        return r;
    }

    private static BigInteger prodTree(int low, int high) {
        if (high <= low) {
            return BigInteger.valueOf(low);
        }

        int diff = high - low;
        if (diff == 1) {
            return BigInteger.valueOf(low * high);
        }

        int mid = low + (diff >>> 1);
        return prodTree(low, mid).multiply(prodTree(mid + 1, high));
    }

    public static BigInteger factTree(int n) {
        if (n < 0)
            return BigInteger.ZERO;
        if (n == 0)
            return BigInteger.ONE;
        if (n == 1 || n == 2)
            return BigInteger.valueOf(n);

        return prodTree(2, n);
    }

    private static BigInteger prodShiftTree(int low, int high) {
        if (high <= low) {
            return BigInteger.valueOf(low >> Integer.numberOfTrailingZeros(low));
        }

        int diff = high - low;
        if (diff == 1) {
            return BigInteger.valueOf(low >> Integer.numberOfTrailingZeros(low)).multiply(
                    BigInteger.valueOf(high >> Integer.numberOfTrailingZeros(high)));
        }

        int mid = low + (diff >>> 1);
        return prodShiftTree(low, mid).multiply(prodShiftTree(mid + 1, high));
    }


    public static BigInteger factShiftTree(int n) {
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

        BigInteger r = prodShiftTree(2, n);

        return r.shiftLeft(c);
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        BigInteger r = naive(10000);
        long t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);

        t1 = System.currentTimeMillis();
        r = factShift(10000);
        t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);

        t1 = System.currentTimeMillis();
        r = factTree(10000);
        t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);

        t1 = System.currentTimeMillis();
        r = factShiftTree(10000);
        t2 = System.currentTimeMillis();
        System.out.println("time: " + (t2 - t1) + ", res: " + r);
    }
}
