/*
 * $Id: DistinctElementFinder.java 07-May-2021 11:00:52 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.HashSet;

import com.japps.learn.util.ArrayUtil;


/**
 * The distinct element finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DistinctElementFinder {

    /**
     * Single number.
     *
     * @param nums the nums
     * @return the int
     */
    public static int singleNumber(final int[] nums) {

        int sum = 0;

        int sumOfDuplicates = 0;

        final HashSet<Integer> numSet = new HashSet<>();

        for (final int num : nums) {
            if (!numSet.add(num)) {
                sumOfDuplicates += num;
            }
            sum += num;
        }

        return sum - 2 * sumOfDuplicates;
    }

    /**
     * Single number by XOR.
     *
     * @param nums the nums
     * @return the single number
     */
    public static int singleNumberByXOR(final int[] nums) {

        return ArrayUtil.xor(nums);
    }
}
