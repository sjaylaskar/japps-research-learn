/*
* $Id: TwoSumCalculator.java 26-May-2021 1:57:30 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The TwoSumCalculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TwoSumCalculator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final TwoSumCalculator twoSumCalculator = new TwoSumCalculator();

        twoSumCalculator.add(1);
        twoSumCalculator.add(3);
        twoSumCalculator.add(5);
        System.out.println("find(7): " + twoSumCalculator.find(7));
        System.out.println("find(4): " + twoSumCalculator.find(4));
        System.out.println("find(1): " + twoSumCalculator.find(1));
        twoSumCalculator.add(9);
        twoSumCalculator.add(5);
        System.out.println("find(10): " + twoSumCalculator.find(10));
        System.out.println("find(12): " + twoSumCalculator.find(12));
    }

    /** The nums. */
    private final List<Integer> nums = new ArrayList<>();

    /**
     * Adds the.
     *
     * @param number the number
     * @return: nothing
     */
    public void add(final int number) {
        nums.add(number);
    }

    /**
     * Find.
     *
     * @param value the value
     * @return {@code true}, if successful
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(final int value) {
        final Set<Integer> differenceSet = new HashSet<>();

        for (final int num : nums) {
            if (differenceSet.contains(num)) {
                return true;
            }
            differenceSet.add(value - num);
        }

        return false;
    }

}