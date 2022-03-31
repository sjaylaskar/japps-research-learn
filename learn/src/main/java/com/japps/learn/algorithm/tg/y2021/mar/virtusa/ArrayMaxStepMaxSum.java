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
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * The array max step max sum.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public final class ArrayMaxStepMaxSum {

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

        final long result = ArrayMaxSum.journey(path, maxStep);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}

class ArrayMaxSum {

    /*
     * Complete the 'journey' function below.
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY path
     * 2. INTEGER maxStep
     */

    public static long journey(final List<Integer> path, final int maxStep) {

        if (path == null || path.isEmpty()) {
            return 0;
        }
        return determineMaximumSum(path.stream().mapToInt(Integer::intValue).toArray(), path.size(), maxStep);
    }

    /**
     * Determines the max sum.
     *
     * @param index the index
     * @param path the path
     * @param lengthOfPath the length of path
     * @param maxSteps the max steps
     * @param sumCache the cache
     * @return the long
     */
    private static long determineMaxSum(final int index, final int []path, final int lengthOfPath, final int maxSteps,
            final long sumCache[]) {

        if (index >= lengthOfPath - 1) {
            return path[lengthOfPath - 1];
        }

        if (sumCache[index] != -1) {
            return sumCache[index];
        }
        long maxSum = Long.MIN_VALUE;

        for (int j = 1; j <= maxSteps; j++) {

            maxSum = Math.max(maxSum,
                determineMaxSum(index + j, path, lengthOfPath, maxSteps, sumCache));
        }

        return sumCache[index] = maxSum + path[index];
    }

    /**
     * Determines the maximum sum.
     *
     * @param path the path
     * @param lengthOfPath the length of path
     * @param maxSteps the max steps
     * @return the long
     */
    private static long determineMaximumSum(final int path[], final int lengthOfPath, final int maxSteps) {

        final long sumCache[] = new long[lengthOfPath];

        Arrays.fill(sumCache, -1);

        return determineMaxSum(0, path, lengthOfPath, maxSteps, sumCache);
    }

}
