/*
* $Id: FibonacciCalculator.java 13-Apr-2021 10:47:30 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.Scanner;

/**
 * The fibonacci calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class FibonacciCalculator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        scanner.close();

        long startTime = System.currentTimeMillis();

        //fibRecursiveTime(n, startTime);

        startTime = System.currentTimeMillis();

        //fibRecursiveDPArrayTime(n, startTime);

        startTime = System.currentTimeMillis();

        fibDPArrayTime(n, startTime);

        startTime = System.currentTimeMillis();

        fibDPVarTime(n, startTime);

    }

    /**
     * Fib DP var time.
     *
     * @param n the n
     * @param startTime the start time
     */
    private static void fibDPVarTime(final int n, final long startTime) {

        System.out.println("fibDPVar(" + n + ") = " + fibDPVar(n));
        System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " ms");
    }

    /**
     * Fib DP array time.
     *
     * @param n the n
     * @param startTime the start time
     */
    private static void fibDPArrayTime(final int n, final long startTime) {

        System.out.println("fibDPArray(" + n + ") = " + fibDPArray(n));
        System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " ms");
    }

    /**
     * Fib recursive cached time.
     *
     * @param n the n
     * @param startTime the start time
     */
    private static void fibRecursiveDPArrayTime(final int n, final long startTime) {

        System.out.println("fibRecursiveDPArray(" + n + ") = " + fibRecursiveDPArray(n, new long[n + 1]));
        System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " ms");
    }

    /**
     * Fib recursive time.
     *
     * @param n the n
     * @param startTime the start time
     */
    private static void fibRecursiveTime(final int n, final long startTime) {

        System.out.println("fibRecursive(" + n + ") = " + fibRecursive(n));
        System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " ms");
    }

    /**
     * Fibonacci recusively.
     *
     * @param n the n
     * @return the nth Fibonacci number
     */
    private static long fibRecursive(final long n) {
        if (n < 0) {
            throw new IllegalArgumentException("The value of n should be 0 or positive.");
        } else if (n <= 1) {
            return n;
        } else {
            return fibRecursive(n-1) + fibRecursive(n-2);
        }
    }

    /**
     * Fibonacci recursively using DP.
     *
     * @param n the n
     * @param memo the memo
     * @return the nth Fibonacci number
     */
    private static long fibRecursiveDPArray(final int n, final long[] memo) {
        if (n < 0) {
            throw new IllegalArgumentException("The value of n should be 0 or positive.");
        } else if (n <= 1) {
            return n;
        } else if (memo[n] == 0) {
            memo[n] = fibRecursive(n-1) + fibRecursive(n-2);
        }
        return memo[n];
    }

    /**
     * Fibonacci iterative with DP array.
     *
     * @param n the n
     * @return the nth Fibonacci number
     */
    private static long fibDPArray(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The value of n should be 0 or positive.");
        }
        final long[] memo = new long[n + 1];

        memo[0] = 0;
        if (n == 0) {
            return memo[0];
        }
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * Fibonacci - DP - variables.
     *
     * @param n the n
     * @return the nth Fibonacci number
     */
    private static long fibDPVar(final long n) {
        if (n < 0) {
            throw new IllegalArgumentException("The value of n should be 0 or positive.");
        }
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1, c;
        for (long i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
