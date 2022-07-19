/*
* $Id: NearestPowerOf2GreaterThanOrEqualToNumberComputer.java 07-Jul-2022 1:45:34 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g.medium;


/**
 * The nearest power of 2 greater than or equal to number computer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NearestPowerOf2GreaterThanOrEqualToNumberComputer {

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
        if (isPowerOf2(n)) {
            return n;
        }
        return Math.round(Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))));
    }

    /**
     * Compute 2.
     *
     * @param n the n
     * @return the long
     */
    private static long compute2(final long n) {
        return (isPowerOf2(n))
                ? n
                : 0x4000000000000000L >> (Long.numberOfLeadingZeros(n) - 2);
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
