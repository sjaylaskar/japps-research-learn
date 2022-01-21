/*
* $Id: NumberUtil.java 18-Apr-2021 6:01:13 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

import java.util.stream.LongStream;

/**
 * The number util.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NumberUtil {

    /**
     * Instantiates a new number util.
     */
    private NumberUtil() {

    }

    /**
     * Factorial.
     *
     * @param num the num
     * @return the factorial
     */
    public static long factorial(final long num) {
        return LongStream.range(1, num).reduce(1, (x, y) -> x * y);
    }

    /**
     * Factorial.
     *
     * @param num the num
     * @return the factorial
     */
    public static long factorial(final int num) {
        return LongStream.range(1, num).reduce(1, (x, y) -> x * y);
    }

    /**
     * Cube.
     *
     * @param n the number
     * @return the cube of the number
     */
    public static long cube(final long n) {
        return (long) Math.pow(n, 3);
    }

    /**
     * Checks if is pair sum equal.
     *
     * @param p the p
     * @param q the q
     * @param r the r
     * @param s the s
     * @return true, if is pair sum equal
     */
    public static boolean isPairSumEqual(final long p, final long q, final long r, final long s) {
        return (p + q) == (r + s);
    }
}
