/*
 * $Id: MultipleOf3Checker.java 07-Jul-2022 3:13:15 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.g4g.medium;

/**
 * The MultipleOf3Checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MultipleOf3Checker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        System.out.println(isDivisibleBy3(Integer.toBinaryString(1000000121)) == isDivisibleBy3(1000000121));
        System.out.println(isDivisibleBy3(Integer.toBinaryString(Math.abs(-1000000121))) == isDivisibleBy3(-1000000121));
        System.out.println(isDivisibleBy3(Integer.toBinaryString(Math.abs(-126))) == isDivisibleBy3(-126));
        System.out.println(isDivisibleBy3(Integer.toBinaryString(Math.abs(-125))) == isDivisibleBy3(-125));
        System.out.println(isDivisibleBy3(Integer.toBinaryString(124568779)) == isDivisibleBy3(124568779));
        System.out.println(isDivisibleBy3(Integer.toBinaryString(900986)) == isDivisibleBy3(900986));
        System.out.println(isDivisibleBy3(Integer.toBinaryString(4500000)) == isDivisibleBy3(4500000));
    }

    private static int isDivisibleBy3(final int n) {
        return (n % 3 == 0) ? 1 : 0;
    }

    /**
     * Indicates if is divisible.
     *
     * @param s the s
     * @return the int
     */
    private static int isDivisibleBy3(final String s) {

        return compute1(s);
        //return compute2(s);
    }

    /**
     * Compute 1.
     *
     * @param s the s
     * @return the int
     */
    private static int compute1(final String s) {

        return (new java.math.BigInteger(s, 2).mod(java.math.BigInteger.valueOf(3)).equals(java.math.BigInteger.ZERO)) ? 1 : 0;
    }

    /**
     * Compute 2.
     *
     * @param s the s
     * @return the int
     */
    private static int compute2(final String s) {

        return isMultipleOf3(s);
    }

    /**
     * Indicates if is multiple of 3.
     *
     * @param s the s
     * @return the int
     */
    private static int isMultipleOf3(final String s) {

        if (s.length() == 1) {
            return (s.charAt(0) == '1') ? 0 : 1;
        }

        int oddBitSetCount = 0;
        int evenBitSetCount = 0;

        for (int i = s.length() - 1; i >= 0; i -= 2) {
            if (s.charAt(i) == '1') {
                oddBitSetCount++;
            }
            if (i > 0 && s.charAt(i - 1) == '1') {
                evenBitSetCount++;
            }
        }
        return ((Math.abs(oddBitSetCount - evenBitSetCount) % 3) == 0) ? 1 : 0;
    }
}
