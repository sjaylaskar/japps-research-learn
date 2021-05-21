/*
 * $Id: SudokuValidator.java 21-May-2021 4:25:42 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The SudokuValidator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SudokuValidator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final char[][] board1 = {{'8','3','.','.','7','.','.','.','.'}
                                ,{'6','.','.','1','9','5','.','.','.'}
                                ,{'.','9','8','.','.','.','.','6','.'}
                                ,{'8','.','.','.','6','.','.','.','3'}
                                ,{'4','.','.','8','.','3','.','.','1'}
                                ,{'7','.','.','.','2','.','.','.','6'}
                                ,{'.','6','.','.','.','.','2','8','.'}
                                ,{'.','.','.','4','1','9','.','.','5'}
                                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board1));

        final char[][] board2 = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board2));

    }

    /**
     * Indicates if is valid sudoku.
     *
     * @param board the board
     * @return {@code true}, if is valid sudoku
     */
    private static boolean isValidSudoku(final char[][] board) {

        return isValidSudoku(board, board.length);
    }

    /**
     * Indicates if is valid sudoku.
     *
     * @param board the board
     * @param length the length
     * @return {@code true}, if is valid sudoku
     */
    private static boolean isValidSudoku(final char[][] board, final int length) {

        final int[] rowChecker = new int[length];
        final int[] colChecker = new int[length];
        final int[] boxChecker = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] != '.') {
                    final int value = (int) Math.pow(2, board[i][j] - '0');
                    if ((rowChecker[i] & value) != 0) {
                        return false;
                    }
                    rowChecker[i] += value;

                    if ((colChecker[j] & value) != 0) {
                        return false;
                    }
                    colChecker[j] += value;

                    final int boxIndex = (3 * (i / 3)) + (j / 3);
                    if ((boxChecker[boxIndex] & value) != 0) {
                        return false;
                    }
                    boxChecker[boxIndex] += value;
                }
            }
        }
        return true;
    }
}
/**
 * CPP:
 * int rowCheck[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 * int colCheck[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 * int boxCheck[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 * for (int i = 0; i < 9; i++) {
 * for (int j = 0; j < 9; j++) {
 * if (board[i][j] != '.') {
 * int value = pow(2, board[i][j] - '0');
 * cout<<i<<','<<j<<': '<<(rowCheck[i])<<' '<<value<<' '<<(rowCheck[i] & value)<<'\n';
 * if (rowCheck[i] & value) {
 * return false;
 * }
 * rowCheck[i] += value;
 * if (colCheck[j] & value) {
 * return false;
 * }
 * colCheck[j] += value;
 * int mod = (3 * (i / 3)) + (j / 3);
 * if (boxCheck[mod] & value) {
 * return false;
 * }
 * boxCheck[mod] += value;
 * }
 * }
 * }
 * return true;
 **/
