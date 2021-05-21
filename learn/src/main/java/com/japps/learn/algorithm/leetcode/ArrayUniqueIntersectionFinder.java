/*
 * $Id: ArrayUniqueIntersectionFinder.java 07-May-2021 10:55:10 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.japps.learn.util.ArrayUtil;


/**
 * The array unique intersection finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ArrayUniqueIntersectionFinder {

    /**
     * Instantiates a new array unique intersection finder.
     */
    private ArrayUniqueIntersectionFinder() {

    }

    /**
     * Intersection.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the int[]
     */
    public static int[] intersection(final int[] nums1, final int[] nums2) {

        final HashSet<Integer> numSet1 = new HashSet<>();
        for (final int num : nums1) {
            numSet1.add(num);
        }

        final HashSet<Integer> numSet2 = new HashSet<>();
        for (final int num : nums2) {
            numSet2.add(num);
        }

        final Set<Integer> intersectionSet = numSet1.
                stream().filter(num -> numSet2.contains(num)).collect(Collectors.toSet());

        final int[] intersectionArray = new int[intersectionSet.size()];
        int index = -1;
        for (final int num : intersectionSet) {
            intersectionArray[++index] = num;
        }
        return intersectionArray;
    }

    /**
     * Intersection by find set.
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the int[]
     */
    public static int[] intersectionByFindSet(final int[] nums1, final int[] nums2) {

        final HashSet<Integer> numSet1 = new HashSet<>();
        for (final int num : nums1) {
            numSet1.add(num);
        }

        final HashSet<Integer> intersectionSet = new HashSet<>();
        for (final int num : nums2) {
             if (numSet1.contains(num)) {
                 intersectionSet.add(num);
             }
        }

        final int[] intersectionArray = new int[intersectionSet.size()];
        int index = -1;
        for (final int num : intersectionSet) {
            intersectionArray[++index] = num;
        }
        return intersectionArray;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        ArrayUtil.print(intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2}));

        ArrayUtil.print(intersection(new int[] {4, 9, 5}, new int[] {1, 4, 6, 9}));

        ArrayUtil.print(intersectionByFindSet(new int[] {1, 2, 2, 1}, new int[] {2, 2}));

        ArrayUtil.print(intersectionByFindSet(new int[] {4, 9, 5}, new int[] {1, 4, 6, 9}));
    }
}
