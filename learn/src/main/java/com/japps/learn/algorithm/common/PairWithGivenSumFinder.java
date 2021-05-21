/*
* $Id: PairWithGivenSumFinder.java 25-Apr-2021 12:58:20 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.japps.learn.util.ArrayUtil;

/**
 * The pair with given sum finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PairWithGivenSumFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        final int[] data = new int[n];

        for (int i = 0; i < n; i++) {
             data[i] = scanner.nextInt();
        }

        final int sum = scanner.nextInt();

        System.out.println((hasPairWithSum(data, sum) ? "Yes" : "No"));

        System.out.println(findPairWithSum(data, sum));

        ArrayUtil.print(twoSum(data, sum));

        scanner.close();

    }

    /**
     * Two sum.
     *
     * @param nums the nums
     * @param target the target
     * @return the int[]
     */
    private static int[] twoSum(final int[] nums, final int target) {
        final Map<Integer, Integer> indexedSumComplementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexedSumComplementMap.containsKey(nums[i])) {
                return new int[]{indexedSumComplementMap.get(nums[i]), i};
            }
            indexedSumComplementMap.put(target - nums[i], i);
        }

        return new int[]{};
    }

    /**
     * Indicates if has pair with sum.
     *
     * @param data the data
     * @param sum the sum
     * @return {@code true}, if successful
     */
    private static boolean hasPairWithSum(final int[] data, final int sum) {

        final Set<Integer> sumComplementSet = new HashSet<>();

        for (final int value : data) {
            if (sumComplementSet.contains(value)) {
                return true;
            }
            sumComplementSet.add(sum - value);
        }

        return false;
    }

    /**
     * Indicates if has pair with sum.
     *
     * @param data the data
     * @param sum the sum
     * @return the pair with sum
     */
    private static PairWithSum findPairWithSum(final int[] data, final int sum) {

        final Set<Integer> sumComplementSet = new HashSet<>();

        for (final int value : data) {
            if (sumComplementSet.contains(value)) {
                final PairWithSum pairWithSum = new PairWithSum(true, new int[] {value, sum - value});
                return pairWithSum;
            }
            sumComplementSet.add(sum - value);
        }

        return PairWithSum.EMPTY_PAIR;
    }

    /**
     * The pair with sum.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    static class PairWithSum {

        /** The empty pair. */
        static final PairWithSum EMPTY_PAIR = new PairWithSum(false, null);

        /** The is found. */
        boolean isFound;

        /** The pair. */
        int[] pair = new int[2];

        /**
         * Instantiates a new pair with sum.
         *
         * @param isFound the is found
         * @param pair the pair
         */
        PairWithSum(final boolean isFound, final int[] pair) {

            if (pair != null && pair.length != 2) {
                throw new IllegalArgumentException("Pair array must be of length 2.");
            }
            this.isFound = isFound;
            this.pair = pair;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return (isFound && pair != null && pair.length == 2)
                    ? ("(" + pair[0] + ", " + pair[1] + ")")
                    : "";
        }

    }
}
