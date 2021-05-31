/*
 * $Id: DistinctThreeSumElementsFinder.java 31-May-2021 6:59:33 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The DistinctThreeSumElementsFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DistinctThreeSumElementsFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[] {0}));
        System.out.println(threeSum(new int[] {}));
    }

    /**
     * Three sum.
     *
     * @param nums the nums
     * @return the list
     */
    private static List<List<Integer>> threeSum(final int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        // return threeSumElementsByTwoPointers(nums, 0);

        //return threeSumElementsByHashSetTwoSum(nums, 0);

        return threeSumElementsByTwoPointers(nums);
    }

    /**
     * Three sum elements.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> threeSumElementsByTwoPointers(final int[] nums, final int target) {

        final int size = nums.length;
        final List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < size - 2; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                break;
            }
            if (nums[i] + nums[size - 2] + nums[size - 1] < target) {
                continue;
            }

            int leftIndex = i + 1, rightIndex = size - 1;
            while (leftIndex < rightIndex) {
                final int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                if (sum == target) {
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex])));
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        ++leftIndex;
                    }
                    while (rightIndex > leftIndex && nums[rightIndex - 1] == nums[rightIndex]) {
                        --rightIndex;
                    }
                    ++leftIndex;
                    --rightIndex;
                } else if (sum < target) {
                    ++leftIndex;
                } else {
                    --rightIndex;
                }
            }

        }

        return triplets;
    }

    /**
     * Three sum by hash set two sum.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> threeSumElementsByHashSetTwoSum(final int[] nums, final int target) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return kSumByHashSetTwoSum(nums, target, 0, 3);
    }

    /**
     * K sum by hash set two sum.
     *
     * @param nums the nums
     * @param target the target
     * @param startIndex the start index
     * @param k the k
     * @return the list
     */
    private static List<List<Integer>> kSumByHashSetTwoSum(final int[] nums, final int target, final int startIndex, final int k) {

        final List<List<Integer>> kSumElements = new ArrayList<>();

        if (nums.length == startIndex || (nums[startIndex] * k > target || target > nums[nums.length - 1] * k)) {
            return kSumElements;
        }

        if (k == 2) {
            return hashSetTwoSum(nums, target, startIndex);
        }

        for (int i = startIndex; i < nums.length; ++i) {
            if (i == startIndex || nums[i - 1] != nums[i]) {
                for (final List<Integer> kSumElement : kSumByHashSetTwoSum(nums, target - nums[i], i + 1, k - 1)) {
                    kSumElements.add(new ArrayList<>(Arrays.asList(nums[i])));
                    kSumElements.get(kSumElements.size() - 1).addAll(kSumElement);
                }
            }
        }

        return kSumElements;
    }

    /**
     * Hash set two sum.
     *
     * @param nums the nums
     * @param target the target
     * @param startIndex the start index
     * @return the list
     */
    private static List<List<Integer>> hashSetTwoSum(final int[] nums, final int target, final int startIndex) {

        final List<List<Integer>> twoSumElements = new ArrayList<>();
        final Set<Integer> complementSet = new HashSet<>();

        for (int i = startIndex; i < nums.length; ++i) {
            if (twoSumElements.isEmpty() || (twoSumElements.get(twoSumElements.size() - 1).get(0) != nums[i])) {
                if (complementSet.contains(target - nums[i])) {
                    twoSumElements.add(Arrays.asList(nums[i], target - nums[i]));
                }
            }
            complementSet.add(nums[i]);
        }

        return twoSumElements;
    }

    /**
     * Three sum elements by two pointers.
     *
     * @param nums the nums
     * @return the list
     */
    private static List<List<Integer>> threeSumElementsByTwoPointers(final int[] nums) {

        final List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return triplets;
    }
}
