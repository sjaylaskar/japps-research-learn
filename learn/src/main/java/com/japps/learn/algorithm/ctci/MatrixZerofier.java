/*
 * $Id: MatrixZerofier.java 28-Jan-2022 1:52:13 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

/**
 * The MatrixZerofier.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MatrixZerofier {

    /**
     * Zero fill matrix.
     *
     * @param matrix the matrix
     */
    public static void zeroFillMatrix(final int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        boolean isFirstRowToBeZeroed = false;
        boolean isFirstColToBeZeroed = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) {
                        isFirstRowToBeZeroed = true;
                    }
                    if (j == 0) {
                        isFirstColToBeZeroed = true;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                zerofy(matrix, i, true);
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                zerofy(matrix, i, false);
            }
        }

        if (isFirstRowToBeZeroed) {
            zerofy(matrix, 0, true);
        }

        if (isFirstColToBeZeroed) {
            zerofy(matrix, 0, false);
        }

    }

    /**
     * Zerofy.
     *
     * @param matrix the matrix
     * @param rowOrColNumber the row or col number
     * @param isZerofyRow the is zerofy row
     */
    private static void zerofy(final int[][] matrix, final int rowOrColNumber, final boolean isZerofyRow) {

        final int maxItems = (isZerofyRow) ? matrix.length : matrix[0].length;
        for (int i = 0; i < maxItems; i++) {
            if (isZerofyRow) {
                matrix[rowOrColNumber][i] = 0;
            } else {
                matrix[i][rowOrColNumber] = 0;
            }
        }
    }
}
