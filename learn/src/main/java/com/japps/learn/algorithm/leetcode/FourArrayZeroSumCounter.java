/*
 * $Id: FourArrayZeroSumCounter.java 27-May-2021 12:03:21 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * The FourArrayZeroSumCounter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class FourArrayZeroSumCounter {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        System.out.println(fourSumCount(new int[] {1, 2},
                                        new int[] {-2, -1},
                                        new int[] {-1, 2},
                                        new int[] {0, 2}));

        System.out.println(fourSumCount(new int[] {0},
                                        new int[] {0},
                                        new int[] {0},
                                        new int[] {0}));

    }

    /**
     * Four sum count.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @param nums3 the nums 3
     * @param nums4 the nums 4
     * @return the int
     */
    private static int fourSumCount(final int[] nums1, final int[] nums2, final int[] nums3, final int[] nums4) {
        return fourSumCountByMap(nums1, nums2, nums3, nums4);
    }

    /**
     * Four sum count.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @param nums3 the nums 3
     * @param nums4 the nums 4
     * @return the int
     */
    private static int fourSumCountByMap(final int[] nums1, final int[] nums2, final int[] nums3, final int[] nums4) {

        final Map<Integer, Integer> sumCountMap = new HashMap<>();

        for (final int num1 : nums1) {
            for (final int num2 : nums2) {
                final int sum = num1 + num2;
                sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
            }
        }

        int fourSumCount = 0;
        for (final int num3 : nums3) {
            for (final int num4 : nums4) {
                fourSumCount += sumCountMap.getOrDefault(-(num3 + num4), 0);
            }
        }

        return fourSumCount;
    }

}
