/*
* $Id: NumberUtil.java 18-Apr-2021 6:01:13 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The number util.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NumberUtil {

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
}
