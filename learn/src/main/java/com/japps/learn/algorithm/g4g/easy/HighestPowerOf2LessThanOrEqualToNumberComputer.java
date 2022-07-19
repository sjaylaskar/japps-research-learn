/*
 * $Id: HighestPowerOf2LessThanOrEqualToNumberComputer.java 07-Jul-2022 1:52:48 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.g4g.easy;

/**
 * The HighestPowerOf2LessThanOrEqualToNumberComputer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class HighestPowerOf2LessThanOrEqualToNumberComputer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        System.out.println(compute1(10));
        System.out.println(compute1(1023));
        System.out.println(compute1(4096));
        System.out.println(compute1(4097));
        System.out.println(compute1(100000000));



          System.out.println(compute2(10));
          System.out.println(compute2(1023));
          System.out.println(compute2(4096));
          System.out.println(compute2(4097));
          System.out.println(compute2(100000000));


    }

    /**
     * Compute 1.
     *
     * @param n the n
     * @return the long
     */
    private static long compute1(final long n) {

        return (isPowerOf2(n))
                ? n
                : Math.round(Math.pow(2, Math.floor(Math.log(n) / Math.log(2))));
    }

    private static long compute2(final long n) {
        return (isPowerOf2(n))
                ? n
                : 0x8000000000000000L >>> (Long.numberOfLeadingZeros(n));
    }

    /**
     * Checks if is power of 2.
     *
     * @param n the n
     * @return true, if is power of 2
     */
    private static boolean isPowerOf2(final long n) {

        return (n & (n - 1)) == 0;
    }
}
