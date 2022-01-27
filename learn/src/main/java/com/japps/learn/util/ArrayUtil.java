/*
 * $Id: ArrayUtil.java 07-May-2021 10:41:10 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

import static com.japps.learn.util.LogUtil.printLn;

import java.util.Arrays;


/**
 * The array utility.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ArrayUtil {

    /**
     * Instantiates a new array util.
     */
    private ArrayUtil() {

    }

    /**
     * Xor.
     *
     * @param nums the nums
     * @return the int
     */
    public static int xor(final int... nums) {

        return Arrays.stream(nums).reduce((x, y) -> x ^ y).getAsInt();
    }

    /**
     * Prints the.
     *
     * @param nums the nums
     */
    public static void print(final int ...nums) {
        printLn();
        LogUtil.print("{");
        for (int i = 0; i < nums.length; i++) {
             LogUtil.print((i == nums.length - 1) ? nums[i] : nums[i] + ", ");
        }
        printLn("}");
    }

    /**
     * Prints the.
     *
     * @param nums the nums
     */
    public static void print(final byte ...nums) {
        printLn();
        LogUtil.print("{");
        for (int i = 0; i < nums.length; i++) {
             LogUtil.print((i == nums.length - 1) ? nums[i] : nums[i] + ", ");
        }
        printLn("}");
    }

    /**
     * Prints the.
     *
     * @param strings the strings
     */
    public static void print(final String ...strings) {
        printLn();
        LogUtil.print("{");
        for (int i = 0; i < strings.length; i++) {
             LogUtil.print((i == strings.length - 1) ? strings[i] : strings[i] + ", ");
        }
        printLn("}");
    }

    /**
     * Swap.
     *
     * @param nums the nums
     * @param index1 the index 1
     * @param index2 the index 2
     */
    public static void swap(final int[] nums, final int index1, final int index2) {
        if (index1 != index2) {
            final int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

    /**
     * Prints the array.
     *
     * @param nums the nums
     */
    public static void print(final int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            print(nums[i]);
        }
    }
}
