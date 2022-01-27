/*
* $Id: MatrixRotaterTest.java 28-Jan-2022 12:07:26 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;


import com.japps.learn.util.ArrayUtil;
import com.japps.learn.util.LogUtil;

/**
 * The MatrixRotaterTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MatrixRotaterTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final int[][] matrix = new int[][] {
            {1, 5, 4, 2},
            {10, 12, 19, 3},
            {3, 4, 6, 0},
            {8, 6, 2, 17}
        };

        ArrayUtil.print(matrix);

        MatrixRotater.rotateClockwise90Degrees(matrix);

        LogUtil.printLn("After rotation: ");

        ArrayUtil.print(matrix);
    }

}
