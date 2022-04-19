/*
 * $Id: SubArrayWithSumGreaterOrEqualToKCounter.java 09-May-2021 12:19:07 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2021.may.falabella;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * The sub array with sum greater or equal to K counter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SubArrayWithSumGreaterOrEqualToKCounter {

    /** The mod val. */
    private static final int MOD_VAL = 1000000007;

    /**
     * Count.
     *
     * @param arr the arr
     * @param n the n
     * @param k the k
     * @return the count
     */
    private static int countForSumGreaterThanK(final long arr[], final int n, final int k) {

        int count = 0;

        for (int i = 1; i < n; i++) {
            arr[i] = ((arr[i] % MOD_VAL) + (arr[i - 1] % MOD_VAL)) % MOD_VAL;
            if (arr[i] > k) {
                count++;
            }
        }

        if (arr[0] >= k) {
            count++;
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            count += n - calculateUpperBound(arr, 0, n, ((arr[i] % MOD_VAL) + (k % MOD_VAL)) % MOD_VAL);
        }

        return count;
    }

    /**
     * Calculate upper bound.
     *
     * @param arr the arr
     * @param low the low
     * @param high the high
     * @param sum the sum
     * @return the upper bound
     */
    private static int calculateUpperBound(final long[] arr, int low,
            int high, final long sum) {

        while (low < high) {
            final int middle = low + (high - low) / 2;
            if (arr[middle] > sum) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    /**
     * Count for sum equal to K.
     *
     * @param arr the arr
     * @param n the n
     * @param k the k
     * @return the count
     */
    private static int countForSumEqualToK(final long arr[], final int n, final int k) {

        final Map<Long, Integer> subArraySumMap = new HashMap<>();

        int count = 0;

        long currentSum = 0;

        for (int i = 0; i < n; i++) {

            currentSum = ((currentSum % MOD_VAL) + (arr[i] % MOD_VAL)) % MOD_VAL;

            if (currentSum == k) {
                count++;
            }

            final Integer countOfCurrentSumMinusK = subArraySumMap.get(currentSum - k);
            if (countOfCurrentSumMinusK != null) {
                count += countOfCurrentSumMinusK;
            }

            final Integer countOfSum = subArraySumMap.get(currentSum);
            if (countOfSum == null) {
                subArraySumMap.put(currentSum, 1);
            } else {
                subArraySumMap.put(currentSum, countOfSum + 1);
            }
        }

        return count;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final long arr[] = {1, 4, 3};
        final int n = arr.length;
        final int k = 4;

        final long[] arrCopy = Arrays.copyOf(arr, n);

        System.out.println(countForSumGreaterThanK(arr, n, k) + countForSumEqualToK(arrCopy, n, k));

    }
}
