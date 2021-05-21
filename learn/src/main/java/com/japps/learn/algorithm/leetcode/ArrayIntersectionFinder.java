/*
* $Id: ArrayIntersectionFinder.java 16-May-2021 1:21:12 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.japps.learn.util.ArrayUtil;

/**
 * The array intersection finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ArrayIntersectionFinder {

    /**
     * Instantiates a new array intersection finder.
     */
    private ArrayIntersectionFinder() {

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        ArrayUtil.print(intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
        ArrayUtil.print(intersect(new int[] {4, 9, 4, 3, 5, 4}, new int[] {4, 9, 4}));
    }

    /**
     * Intersect.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the int[]
     */
    private static int[] intersect(final int[] nums1, final int[] nums2) {
        /*return (nums1.length <= nums2.length)
               ? intersectByMap(nums2, nums1)
               : intersectByMap(nums1, nums2); */

        /*
         * return (nums1.length <= nums2.length)
         * ? intersectByMapAndArray(nums2, nums1)
         * : intersectByMapAndArray(nums1, nums2);
         */

        return (nums1.length <= nums2.length)
                ? intersectByArray(nums2, nums1)
                : intersectByArray(nums1, nums2);
    }

    /**
     * Intersect by map.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the int[]
     */
    private static int[] intersectByMap(final int[] nums1, final int[] nums2) {
        final HashMap<Integer, Integer> nums1FrequencyMap = new HashMap<>();

        for (final int num : nums1) {
             final Integer numFreq = nums1FrequencyMap.get(num);
             if (numFreq != null) {
                 nums1FrequencyMap.put(num, numFreq + 1);
             } else {
                 nums1FrequencyMap.put(num, 1);
             }
        }

        final ArrayList<Integer> numsIntersectList = new ArrayList<>();

        for (final int num : nums2) {
            final Integer numFreq = nums1FrequencyMap.get(num);
            if (numFreq != null && numFreq > 0) {
                numsIntersectList.add(num);
                nums1FrequencyMap.put(num, numFreq - 1);
             }
        }

        return numsIntersectList.stream().filter(z -> z != null).mapToInt(z -> z).toArray();
    }

    /**
     * Intersect by map and array.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the int[]
     */
    private static int[] intersectByMapAndArray(final int[] nums1, final int[] nums2) {
        final HashMap<Integer, Integer> nums1FrequencyMap = new HashMap<>();

        for (final int num : nums1) {
             final Integer numFreq = nums1FrequencyMap.get(num);
             if (numFreq != null) {
                 nums1FrequencyMap.put(num, numFreq + 1);
             } else {
                 nums1FrequencyMap.put(num, 1);
             }
        }

        final ArrayList<Integer> numsIntersectList = new ArrayList<>();

        for (final int num : nums2) {
            final Integer numFreq = nums1FrequencyMap.get(num);
            if (numFreq != null && numFreq > 0) {
                numsIntersectList.add(num);
                nums1FrequencyMap.put(num, numFreq - 1);
             }
        }

        final int[] numsIntersectArray = new int[numsIntersectList.size()];
        int index = -1;
        for (final int num : numsIntersectList) {
            numsIntersectArray[++index] = num;
        }

        return numsIntersectArray;
    }

    /**
     * Intersect by array.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the int[]
     */
    private static int[] intersectByArray(final int[] nums1, final int[] nums2) {
        final int[] nums2Frequencies = new int[1001];

        for (int i = 0; i < nums2.length; i++) {
            nums2Frequencies[nums2[i]]++;
        }

        final int[] intersection = new int[nums2.length];
        int index = -1;
        for (int i = 0; i < nums1.length; i++) {
            if (i < nums1.length && nums2Frequencies[nums1[i]] > 0) {
                intersection[++index] = nums1[i];
                nums2Frequencies[nums1[i]]--;
            }
        }

        return Arrays.copyOf(intersection, index + 1);
    }
}