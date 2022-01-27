/*
 * $Id: MatrixRotater.java 28-Jan-2022 12:06:46 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

/**
 * The MatrixRotater.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MatrixRotater {

    /**
     * Rotate clockwise 90 degrees.
     *
     * @param matrix the matrix
     */
    public static void rotateClockwise90Degrees(final int[][] matrix) {

        if (matrix == null || matrix[0] == null || matrix[0].length != matrix.length) {
            return;
        }
        final int n = matrix.length;
        for (int layerIndex = 0; layerIndex < n / 2; layerIndex++) {
            final int startIndex = layerIndex;
            final int endIndex = n - 1 - layerIndex;
            for (int index = startIndex; index < endIndex; index++) {
                final int gap = index - startIndex;

                // Save Top
                final int top = matrix[startIndex][index];

                // Left -> Top
                matrix[startIndex][index] = matrix[endIndex - gap][startIndex];

                // Bottom -> Left
                matrix[endIndex - gap][startIndex] = matrix[endIndex][endIndex - gap];

                // Right -> Bottom
                matrix[endIndex][endIndex - gap] = matrix[index][endIndex];

                // Top -> Right
                matrix[index][endIndex] = top;
            }
        }
    }

}
