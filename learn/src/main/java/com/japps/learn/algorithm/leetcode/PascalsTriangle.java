/*
* $Id: PascalsTriangle.java 18-Apr-2021 3:45:19 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The pascals triangle.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PascalsTriangle {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        //System.out.println(getRow(scanner.nextInt()));

        //display(pascalsTriangle(scanner.nextInt()));

        displayRow(pascalRowBinomialCoeffs(scanner.nextInt()));

        scanner.close();
    }

    /**
     * Gets the row.
     *
     * @param rowIndex the row index
     * @return the row
     */
    public static List<Integer> getRow(final int rowIndex) {
        //return getPascalRowRecursive(rowIndex);
        //return getPascalRowIterative(rowIndex);
        //return Arrays.stream(pascalRowBinomialCoeffs(rowIndex)).boxed().collect(Collectors.toList());
        return null;
    }

    /**
     * Gets the pascal row recursive.
     *
     * @param rowIndex the row index
     * @return the row
     */
    public static List<Integer> getPascalRowRecursive(final int rowIndex) {
        final List<Integer> pascalRow = new ArrayList<>(rowIndex + 1);

        for (int colIndex = 0; colIndex <= rowIndex / 2; colIndex++) {
            pascalRow.add(pascalRecursive(rowIndex, colIndex));
        }
        for (int colIndex = (rowIndex % 2 == 0) ? rowIndex / 2 - 1 : rowIndex / 2; colIndex >= 0; colIndex--) {
            pascalRow.add(pascalRow.get(colIndex));
        }

        return pascalRow;
    }

    /**
     * Pascal recursive.
     *
     * @param rowIndex the row index
     * @param colIndex the col index
     * @return the integer
     */
    public static Integer pascalRecursive(final int rowIndex, final int colIndex) {
        if (colIndex == 0 || colIndex == rowIndex) {
            return 1;
        }
        return pascalRecursive(rowIndex - 1, colIndex - 1) + pascalRecursive(rowIndex - 1, colIndex);
    }


      /**
       * Gets the pascal row iterative.
       *
       * @param rowIndex the row index
       * @return the pascal row iterative
       */
      public static List<Integer> getPascalRowIterative(final int rowIndex) {
          return pascalIterative(rowIndex);
      }


    /**
     * Pascal iterative.
     *
     * @param rowIndex the row index
     * @return the list
     */
    public static List<Integer> pascalIterative(final int rowIndex) {
        final List<Integer> pascalRow = new ArrayList<>(rowIndex + 1);

        for (int i = 0; i <= rowIndex; i++) {
            pascalRow.add(1);
            for (int j = i; j >= 0; j--) {
                if (j != 0 && j != i) {
                    pascalRow.set(j, pascalRow.get(j) + pascalRow.get(j - 1));
                }
            }
        }

        return pascalRow;
    }

    /**
     * Gets the pascal row binomial coeffs.
     *
     * @param k the k
     * @return the pascal row binomial coeffs
     */
    public static int[] pascalRowBinomialCoeffs(final int k) {
        final int[] kthPascalRow = new int[k + 1];
        kthPascalRow[0] = 1;
        for (int i = 1; i <= k; i++) {
            kthPascalRow[i] = (kthPascalRow[i - 1] * (k - i + 1)) / i;
        }

        return kthPascalRow;
      }

    /**
     * Pascals triangle.
     *
     * @param rowIndex the row index
     * @return the list
     */
    public static List<List<Integer>> pascalsTriangle(final int rowIndex) {
        //final List<Integer> pascalRow = new ArrayList<>(rowIndex + 1);

        final List<List<Integer>> pascalRows = new ArrayList<>();

        IntStream.range(0, rowIndex).forEach(x -> pascalRows.add(getPascalRowIterative(x)));

        //for (int i = 0; i <= rowIndex; i++) {
            /*
             * pascalRow.add(1);
             * for (int j = i; j >= 0; j--) {
             * if (j != 0 && j != i) {
             * pascalRow.set(j, pascalRow.get(j) + pascalRow.get(j - 1));
             * }
             * }
             * pascalRows.add(new ArrayList<>(pascalRow));
             */
           // pascalRows.add(getPascalRowIterative(i));
        //}

        return pascalRows;
    }

    /**
     * Display.
     *
     * @param pascalRows the pascal rows
     */
    public static void display(final List<List<Integer>> pascalRows) {

        pascalRows.forEach(PascalsTriangle::displayRow);
    }

    /**
     * Display row.
     *
     * @param pascalRow the pascal row
     */
    private static void displayRow(final List<Integer> pascalRow) {

        pascalRow.forEach(number -> System.out.print(number + " "));
        System.out.println();
    }

    /**
     * Display row.
     *
     * @param pascalRow the pascal row
     */
    private static void displayRow(final int[] pascalRow) {
        Arrays.stream(pascalRow).forEach(value -> System.out.print(value + " "));
    }
}
