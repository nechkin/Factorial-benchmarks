package org.sample;

import java.math.BigInteger;
import java.util.Random;

public class FactFactorization {

    public static BigInteger fact(int n) {
        if (n < 0)
            return BigInteger.ZERO;
        if (n == 0)
            return BigInteger.ONE;
        if (n == 1 || n == 2)
            return BigInteger.valueOf(n);

        boolean[] notPrimes = notPrimes(n);
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i <= n; i++) {
            if (notPrimes[i]) {
                continue;
            }

            int power = 0;
            int k = n / i;
            do {
                power += k;
                k /= i;
            } while (k > 0);

            result = result.multiply(BigInteger.valueOf(i).pow(power));
        }

        return result;
    }

    /**
     * Sieve of Eratosthenes
     * precondition: n > 2
     * @return boolean array. If a[i] == false than i is a prime number
     */
    private static boolean[] notPrimes(int n) {
        // not primes, so that array is correctly initialized on init
        final boolean[] notPrime = new boolean[n + 1];
        notPrime[0] = true; // 0 is not prime
        notPrime[1] = true; // 1 is not prime
        // 2 is prime, so notPrime[2] == false

        // loop for every 2 element extracted since j step is j += 2, for i other than 2, step is j += 2 * i
        // because every even number is already visited by this loop
        for (int j = 4; j <= n; j += 2) {
            notPrime[j] = true;
        }

        for (int i = 3; i <= n; ++i) {
            if (notPrime[i]) {
                // searching the next not visited item
                continue;
            }

            int pow = i * i;
            if (pow > n) {
                break;
            }

            // e.g. i = 5. 2 * 5 is visited by i = 2. 3 * 5 is visited by i = 3. etc. so we start from 5 * 5.
            for (int j = pow; j <= n; j += 2 * i) {
                notPrime[j] = true;
            }
        }

        return notPrime;
    }

    /**
     * X^n = (X^2)^(n/2) if n is even, or X * (X^2)^(n/2) if n is odd
     */
    // private static int pow(int base, int exp) {
    //     if (exp == 0) {
    //         return 1;
    //     }
    //
    //     int result = base;
    //     while (exp > 1) {
    //         if ((exp & 1) == 1) result *= base;
    //         result = result * result;
    //         exp >>= 1;
    //     }
    //
    //     return result;
    // }

    public static void main(String[] args) {
        System.out.println("Expected = " + FactShiftTree.naive(9) + "\nActual = " + fact(9));
        Random r = new Random();
        for (int i = 0; i < 20; ++i) {
            int n = r.nextInt(50000);
            if (!fact(n).equals(FactShiftTree.naive(n))) {
                System.out.println("Expected = " + FactShiftTree.naive(n) + "\nActual = " + fact(n));
                throw new RuntimeException(String.valueOf(n));
            }
        }
    }
}
