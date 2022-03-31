/*
 * $$ Id: ArrayMaxStepMaxSum.java 26-Mar-2021 3:26:13 am SubhajoyLaskar $$
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2021.mar.virtusa;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import com.japps.learn.util.Pair;


/**
 * The array max step max sum.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public final class ArrayMaxStepMaxSumPrioQueueImpl {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int pathCount = Integer.parseInt(bufferedReader.readLine().trim());

        final List<Integer> path = IntStream.range(0, pathCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (final IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        final int maxStep = Integer.parseInt(bufferedReader.readLine().trim());

        final long result = MaxSumDeterminer.journey(path, maxStep);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}

/**
 * The max sum determiner.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
class MaxSumDeterminer {

    /**
     * Journey.
     *
     * @param path the path
     * @param maxSteps the max steps
     * @return the sum
     */
    public static long journey(final List<Integer> path, final int maxSteps) {

        if (path == null || path.isEmpty()) {
            return 0;
        }
        return determineMaximumSum(path.stream().mapToInt(Integer::intValue).toArray(), maxSteps);
    }

    /**
     * Maximum sum.
     *
     * @param path the path
     * @param maxSteps the max steps
     * @return the max sum
     */
    private static int determineMaximumSum(final int path[], final int maxSteps)
    {

        return calculateMaxSum(path, maxSteps);
    }

    /**
     * Calculate max sum.
     *
     * @param path the path
     * @param maxSteps the max steps
     * @param maxSum the max sum
     * @return the max sum
     */
    private static int calculateMaxSum(final int[] path, final int maxSteps) {

        int maxSum = 0;

        /*
         * final PriorityQueue<Entry<Integer, Integer>> priorityQueueMaxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1,
         * e2) -> Integer.compare(e1.getKey(), e2.getKey()));
         * priorityQueueMaxHeap.add(new AbstractMap.SimpleEntry<Integer, Integer>(path[0], 0));
         * for (int i = 1; i < path.length; i++) {
         * while (priorityQueueMaxHeap.peek().getValue() < (i - maxSteps)) {
         * priorityQueueMaxHeap.poll();
         * }
         * maxSum = path[i] + priorityQueueMaxHeap.peek().getKey();
         * priorityQueueMaxHeap.add(new AbstractMap.SimpleEntry<Integer, Integer>(maxSum, i));
         * }
         */

        final PriorityQueue<Pair<Integer, Integer>> priorityQueueMaxHeap = new PriorityQueue<Pair<Integer, Integer>>((e1, e2) -> Integer.compare(e2.first(), e1.first()));

        priorityQueueMaxHeap.add(new Pair<Integer, Integer>(path[0], 0));

        for (int i = 1; i < path.length; i++) {
            while (priorityQueueMaxHeap.peek().second() < (i - maxSteps)) {
                priorityQueueMaxHeap.poll();
            }

            maxSum = path[i] + priorityQueueMaxHeap.peek().first();

            priorityQueueMaxHeap.add(new Pair<Integer, Integer>(maxSum, i));
        }

        return maxSum;
    }
}
