/*
 * $Id: MatrixZerofierTest.java 28-Jan-2022 1:53:47 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

import com.japps.learn.util.ArrayUtil;
import com.japps.learn.util.LogUtil;


/**
 * The MatrixZerofierTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MatrixZerofierTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        test1();

        test2();

        test3();
    }

    /**
     * Test 1.
     */
    private static void test1() {

        final int[][] matrix = new int[][] {
            {1, 5, 4, 2},
            {10, 12, 19, 3},
            {3, 4, 6, 0},
            {8, 6, 2, 17}
        };
        LogUtil.printLn("Matrix: ");
        ArrayUtil.print(matrix);
        MatrixZerofier.zeroFillMatrix(matrix);
        LogUtil.printLn("After zerofication: ");
        ArrayUtil.print(matrix);
    }

    /**
     * Test 2.
     */
    private static void test2() {

        final int[][] matrix = new int[][] {
            {1, 0, 4, 2},
            {10, 12, 19, 3},
            {3, 4, 6, 0},
            {8, 6, 2, 17}
        };
        LogUtil.printLn("Matrix: ");
        ArrayUtil.print(matrix);
        MatrixZerofier.zeroFillMatrix(matrix);
        LogUtil.printLn("After zerofication: ");
        ArrayUtil.print(matrix);
    }

    /**
     * Test 3.
     */
    private static void test3() {

        final int[][] matrix = new int[][] {
            {1, 9, 4, 2},
            {10, 12, 0, 3},
            {3, 4, 6, 8},
            {8, 0, 2, 17}
        };
        LogUtil.printLn("Matrix: ");
        ArrayUtil.print(matrix);
        MatrixZerofier.zeroFillMatrix(matrix);
        LogUtil.printLn("After zerofication: ");
        ArrayUtil.print(matrix);
    }
}
