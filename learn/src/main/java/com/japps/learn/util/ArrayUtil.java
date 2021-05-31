/*
 * $Id: ArrayUtil.java 07-May-2021 10:41:10 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

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
        System.out.println();
        System.out.print("{");
        for (int i = 0; i < nums.length; i++) {
             System.out.print((i == nums.length - 1) ? nums[i] : nums[i] + ", ");
        }
        System.out.println("}");
    }

    /**
     * Prints the.
     *
     * @param nums the nums
     */
    public static void print(final byte ...nums) {
        System.out.println();
        System.out.print("{");
        for (int i = 0; i < nums.length; i++) {
             System.out.print((i == nums.length - 1) ? nums[i] : nums[i] + ", ");
        }
        System.out.println("}");
    }

    /**
     * Prints the.
     *
     * @param strings the strings
     */
    public static void print(final String ...strings) {
        System.out.println();
        System.out.print("{");
        for (int i = 0; i < strings.length; i++) {
             System.out.print((i == strings.length - 1) ? strings[i] : strings[i] + ", ");
        }
        System.out.println("}");
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
}
