/*
* $Id: TopKElementsFinder.java 26-May-2021 3:45:42 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

import com.japps.learn.util.ArrayUtil;

/**
 * The top K elements finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TopKElementsFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        ArrayUtil.print(topKFrequentByMap(new int[]{1, 2, 1, 3, 1, 2, 4}, 2));
        ArrayUtil.print(topKFrequentByMap(new int[]{1, 2}, 2));
        ArrayUtil.print(topKFrequentByMap(new int[]{1}, 1));

        ArrayUtil.print(topKFrequentByTree(new int[]{1, 2, 1, 3, 1, 2, 4}, 2));
        ArrayUtil.print(topKFrequentByTree(new int[]{1, 2}, 2));
        ArrayUtil.print(topKFrequentByTree(new int[]{1}, 1));

        ArrayUtil.print(topKFrequentByPriorityQueueMaxHeap(new int[]{1, 2, 1, 3, 1, 2, 4}, 2));
        ArrayUtil.print(topKFrequentByPriorityQueueMaxHeap(new int[]{1, 2}, 2));
        ArrayUtil.print(topKFrequentByPriorityQueueMaxHeap(new int[]{1}, 1));
    }

    /**
     * Top K frequent.
     *
     * @param nums the nums
     * @param k the k
     * @return the int[]
     */
    private static int[] topKFrequentByMap(final int[] nums, final int k) {
        final Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (final int num : nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }

        final int[] topKFrequentElements = new int[k];
        for (int i = 0; i < k; i++) {
            int maxValue = 0;
            int maxKey = 0;
            for (final Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
                if (maxValue < entry.getValue()) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            topKFrequentElements[i] = maxKey;
            numFrequencyMap.remove(maxKey);
        }

        return topKFrequentElements;
    }

    /**
     * Top K frequent by tree.
     *
     * @param nums the nums
     * @param k the k
     * @return the int[]
     */
    private static int[] topKFrequentByTree(final int[] nums, final int k) {
        final Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (final int num : nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }

        final TreeSet<NumFrequency> numFrequencySet = new TreeSet<>((x, y) -> (x.frequency == y.frequency) ? 1 :  -Integer.compare(x.frequency, y.frequency));

        for (final Map.Entry<Integer, Integer> numFrequencyEntry : numFrequencyMap.entrySet()) {
            numFrequencySet.add(new NumFrequency(numFrequencyEntry.getKey(), numFrequencyEntry.getValue()));
        }

        final int[] topKFrequentElements = new int[k];
        int index = 0;
        for (final NumFrequency numFrequency : numFrequencySet) {
            if (index == k) {
                break;
            }
            topKFrequentElements[index++] = numFrequency.num;
        }

        return topKFrequentElements;
    }

    /**
     * The num frequency.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static final class NumFrequency {

        /** The num. */
        int num;

        /** The frequency. */
        int frequency;

        /**
         * Instantiates a new num frequency.
         *
         * @param num the num
         * @param frequency the frequency
         */
        public NumFrequency(final int num, final int frequency) {

            this.num = num;
            this.frequency = frequency;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return num + ":" + frequency;
        }
    }

    /**
     * Top K frequent by priority queue max heap.
     *
     * @param nums the nums
     * @param k the k
     * @return the int[]
     */
    private static int[] topKFrequentByPriorityQueueMaxHeap(final int[] nums, final int k) {
        final int[] topKFrequentElements = new int[k];

        final PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((x, y) -> y[1] - x[1]);

        Arrays.sort(nums);

        int frequency = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                frequency++;
            } else {
                maxHeap.add(new int[]{nums[i - 1], frequency});
                frequency = 1;
            }
        }
        maxHeap.add(new int[]{nums[nums.length - 1], frequency});

        for (int i = 0; i < k; i++) {
            topKFrequentElements[i] = maxHeap.poll()[0];
        }

        return topKFrequentElements;
    }
}
