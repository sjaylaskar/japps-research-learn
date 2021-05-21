/*
 * $Id: DuplicateElementIndicesLessThanEqualToKChecker.java 16-May-2021 4:23:38 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;


/**
 * The duplicate element indices less than equal to K checker.
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DuplicateElementIndicesLessThanEqualToKChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println(containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));


        System.out.println(containsNearbyDuplicateBySet(new int[] {1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicateBySet(new int[] {1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicateBySet(new int[] {1, 2, 3, 1, 2, 3}, 2));
    }

    /**
     * Contains nearby duplicate.
     *
     * @param nums the nums
     * @param k the k
     * @return {@code true}, if successful
     */
    private static boolean containsNearbyDuplicate(final int[] nums, final int k) {

        final HashMap<Integer, Integer> numsIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final Integer numIndex = numsIndexMap.get(nums[i]);
            if (numIndex != null) {
                if (Math.abs(numIndex - i) <= k) {
                    return true;
                } else {
                    numsIndexMap.put(nums[i], i);
                }
            } else {
                numsIndexMap.put(nums[i], i);
            }
        }

        return false;
    }

    /**
     * Contains nearby duplicate by set.
     *
     * @param nums the nums
     * @param k the k
     * @return {@code true}, if successful
     */
    private static boolean containsNearbyDuplicateBySet(final int[] nums, final int k) {

        final HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numSet.add(nums[i])) {
                return true;
            }

            if (i >= k) {
                numSet.remove(nums[i - k]);
            }
        }

        return false;
    }
}
