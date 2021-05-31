/*
 * $Id: DistinctFourSumElementsFinder.java 31-May-2021 5:12:53 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * The DistinctFourSumElementsFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DistinctFourSumElementsFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println(fourSumElements(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSumElements(new int[] {2, 2, 2, 2, 2}, 8));
        System.out.println(fourSumElements(new int[] {2, 2, 2}, 8));
        System.out.println(fourSumElements(new int[] {2, 2, 2, 2, 2}, 0));
        System.out.println(fourSumElements(new int[] {}, 8));
        System.out.println(fourSumElements(null, 8));

        System.out.println("==================================================================");
        long startTime = System.currentTimeMillis();
        System.out.println(fourSumByTwoPointerTwoSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSumByTwoPointerTwoSum(new int[] {2, 2, 2, 2, 2}, 8));
        System.out.println(fourSumByTwoPointerTwoSum(new int[] {2, 2, 2}, 8));
        System.out.println(fourSumByTwoPointerTwoSum(new int[] {2, 2, 2, 2, 2}, 0));
        System.out.println(fourSumByTwoPointerTwoSum(new int[] {}, 8));
        System.out.println(fourSumByTwoPointerTwoSum(null, 8));
        System.out.println(System.currentTimeMillis() - startTime + " ms.");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        startTime = System.currentTimeMillis();
        System.out.println(fourSumByHashSetTwoSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSumByHashSetTwoSum(new int[] {2, 2, 2, 2, 2}, 8));
        System.out.println(fourSumByHashSetTwoSum(new int[] {2, 2, 2}, 8));
        System.out.println(fourSumByHashSetTwoSum(new int[] {2, 2, 2, 2, 2}, 0));
        System.out.println(fourSumByHashSetTwoSum(new int[] {}, 8));
        System.out.println(fourSumByHashSetTwoSum(null, 8));
        System.out.println(System.currentTimeMillis() - startTime + " ms.");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        startTime = System.currentTimeMillis();
        System.out.println(fourSumByTwoPointer(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSumByTwoPointer(new int[] {2, 2, 2, 2, 2}, 8));
        System.out.println(fourSumByTwoPointer(new int[] {2, 2, 2}, 8));
        System.out.println(fourSumByTwoPointer(new int[] {2, 2, 2, 2, 2}, 0));
        System.out.println(fourSumByTwoPointer(new int[] {}, 8));
        System.out.println(fourSumByTwoPointer(null, 8));
        System.out.println(System.currentTimeMillis() - startTime + " ms.");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        startTime = System.currentTimeMillis();
        System.out.println(fourSumByHashMapPairSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSumByHashMapPairSum(new int[] {2, 2, 2, 2, 2}, 8));
        System.out.println(fourSumByHashMapPairSum(new int[] {2, 2, 2}, 8));
        System.out.println(fourSumByHashMapPairSum(new int[] {2, 2, 2, 2, 2}, 0));
        System.out.println(fourSumByHashMapPairSum(new int[] {}, 8));
        System.out.println(fourSumByHashMapPairSum(null, 8));
        System.out.println(System.currentTimeMillis() - startTime + " ms.");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
    }

    /**
     * Four sum elements.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> fourSumElements(final int[] nums, final int target) {

        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        return fourSum(nums, target);
    }

    /**
     * Four sum.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> fourSum(final int[] nums, final int target) {

        //return fourSumByTwoPointerTwoSum(nums, target);
        //return fourSumByHashSetTwoSum(nums, target);
        //return fourSumByTwoPointer(nums, target);
        return fourSumByHashMapPairSum(nums, target);
    }

    /**
     * Four sum by two pointer two sum.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> fourSumByTwoPointerTwoSum(final int[] nums, final int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return kSumByTwoPointerTwoSum(nums, target, 0, 4);
    }

    /**
     * K sum by two pointer two sum.
     *
     * @param nums the nums
     * @param target the target
     * @param startIndex the start index
     * @param k the k
     * @return the list
     */
    private static List<List<Integer>> kSumByTwoPointerTwoSum(final int[] nums, final int target, final int startIndex,
            final int k) {

        final List<List<Integer>> kSumElements = new ArrayList<>();

        if (nums.length == startIndex || (nums[startIndex] * k > target || target > nums[nums.length - 1] * k)) {
            return kSumElements;
        }

        if (k == 2) {
            return twoPointerTwoSum(nums, target, startIndex);
        }

        for (int i = startIndex; i < nums.length; ++i) {
            if (i == startIndex || nums[i - 1] != nums[i]) {
                for (final List<Integer> kSumElement : kSumByTwoPointerTwoSum(nums, target - nums[i], i + 1, k - 1)) {
                    kSumElements.add(new ArrayList<>(Arrays.asList(nums[i])));
                    kSumElements.get(kSumElements.size() - 1).addAll(kSumElement);
                }
            }
        }

        return kSumElements;
    }

    /**
     * Two pointer two sum.
     *
     * @param nums the nums
     * @param target the target
     * @param startIndex the start index
     * @return the list
     */
    private static List<List<Integer>> twoPointerTwoSum(final int[] nums, final int target, final int startIndex) {

        final List<List<Integer>> twoSumElements = new ArrayList<>();

        int lowIndex = startIndex, highIndex = nums.length - 1;

        while (lowIndex < highIndex) {
            final int sum = nums[lowIndex] + nums[highIndex];
            if (sum < target || (lowIndex > startIndex && nums[lowIndex - 1] == nums[lowIndex])) {
                ++lowIndex;
            } else if (sum > target || (highIndex < nums.length - 1 && nums[highIndex] == nums[highIndex + 1])) {
                --highIndex;
            } else {
                twoSumElements.add(Arrays.asList(nums[lowIndex++], nums[highIndex--]));
            }
        }

        return twoSumElements;
    }

    /**
     * Four sum by hash set two sum.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> fourSumByHashSetTwoSum(final int[] nums, final int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return kSumByHashSetTwoSum(nums, target, 0, 4);
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
     * Four sum by two pointer.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> fourSumByTwoPointer(final int[] nums, final int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return fourSumByTwoPointer(nums, target, nums.length);
    }

    /**
     * Four sum by two pointer.
     *
     * @param nums the nums
     * @param target the target
     * @param size the size
     * @return the list
     */
    private static List<List<Integer>> fourSumByTwoPointer(final int[] nums, final int target, final int size) {

        final List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < size - 3; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[size - 3] + nums[size - 2] + nums[size - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < size - 2; ++j) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[size - 2] + nums[size - 1] < target) {
                    continue;
                }
                int leftIndex = j + 1, rightIndex = size - 1;
                while (leftIndex < rightIndex) {
                    final int sum = nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex];
                    if (sum == target) {
                        quadruplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[leftIndex], nums[rightIndex])));
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
        }

        return quadruplets;
    }

    /**
     * Four sum by hash map pair sum.
     *
     * @param nums the nums
     * @param target the target
     * @return the list
     */
    private static List<List<Integer>> fourSumByHashMapPairSum(final int[] nums, final int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        final Map<Integer, List<Pair>> pairIndicesBySumMap = computePairIndicesBySumMap(nums);

        return fourSumByHashSetOfPairSum(nums, target, pairIndicesBySumMap);
    }

    /**
     * Compute pair indices by sum map.
     *
     * @param nums the nums
     * @return the map
     */
    private static Map<Integer, List<Pair>> computePairIndicesBySumMap(final int[] nums) {

        final Map<Integer, List<Pair>> pairIndicesBySumMap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                final int sum = nums[i] + nums[j];
                final Pair pair = new Pair(i, j);
                if (!pairIndicesBySumMap.containsKey(sum)) {
                    final List<Pair> pairs = new ArrayList<>();
                    pairs.add(pair);
                    pairIndicesBySumMap.put(sum, pairs);
                } else {
                    pairIndicesBySumMap.get(sum).add(pair);
                }
            }
        }

        return pairIndicesBySumMap;
    }

    /**
     * The pair.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static final class Pair {

        /** The index 2. */
        int index1, index2;

        /**
         * Instantiates a new pair.
         *
         * @param index1 the index 1
         * @param index2 the index 2
         */
        Pair(final int index1, final int index2) {

            this.index1 = index1;
            this.index2 = index2;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return "(" + index1 + ", " + index2 + ")";
        }
    }

    /**
     * Four sum by hash set of pair sum.
     *
     * @param nums the nums
     * @param target the target
     * @param pairIndicesBySumMap the pair indices by sum map
     * @return the list
     */
    private static List<List<Integer>> fourSumByHashSetOfPairSum(final int[] nums, final int target,
            final Map<Integer, List<Pair>> pairIndicesBySumMap) {

        final Set<List<Integer>> quadrupletSet = new HashSet<>();

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                final int targetMinusPairSum = target - (nums[i] + nums[j]);
                if (pairIndicesBySumMap.containsKey(targetMinusPairSum)) {

                    final List<Pair> pairs = pairIndicesBySumMap.get(targetMinusPairSum);

                    for (final Pair pair : pairs) {
                        if (notEqual(pair.index1, i)
                            && notEqual(pair.index1, j)
                            && notEqual(pair.index2, i)
                            && notEqual(pair.index2, j)) {
                            final List<Integer> quadruplet = new ArrayList<>();
                            quadruplet.add(nums[i]);
                            quadruplet.add(nums[j]);
                            quadruplet.add(nums[pair.index1]);
                            quadruplet.add(nums[pair.index2]);

                            Collections.sort(quadruplet);

                            quadrupletSet.add(quadruplet);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(quadrupletSet);
    }

    /**
     * Not equal.
     *
     * @param x the x
     * @param y the y
     * @return {@code true}, if successful
     */
    private static boolean notEqual(final int x, final int y) {

        return x != y;
    }
}
