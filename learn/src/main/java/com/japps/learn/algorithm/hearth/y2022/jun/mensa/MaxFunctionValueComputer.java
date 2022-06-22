/*
 * $Id: MaxFunctionValueComputer.java 22-Jun-2022 10:18:28 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jun.mensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 * The max function value computer.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public class MaxFunctionValueComputer {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int n = Integer.parseInt(br.readLine().trim());
        final String[] arr_A = br.readLine().split(" ");
        final int[] arrA = new int[n];
        for (int i_A = 0; i_A < arr_A.length; i_A++) {
            arrA[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        final String[] arr_B = br.readLine().split(" ");
        final int[] arrB = new int[n];
        for (int i_B = 0; i_B < arr_B.length; i_B++) {
            arrB[i_B] = Integer.parseInt(arr_B[i_B]);
        }
        System.out.println(solve(n, arrA, arrB));
        System.out.println(solve2(n, arrA, arrB));

        wr.close();
        br.close();
    }

    /**
     * Solve.
     *
     * @param n the n
     * @param arrA the arr A
     * @param arrB the arr B
     * @return the int
     */
    private static int solve(final int n, final int[] arrA, final int[] arrB) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                 max = Math.max(max, (arrA[i] - arrB[j]) + (arrA[j] - arrB[i]));
            }
        }

        return max;

    }

    private static int solve2(final int n, final int[] arrA, final int[] arrB){
        final int[] dp1 = new int[n + 1];
        final int[] dp2 = new int[n];
        Arrays.fill(dp1, Integer.MIN_VALUE);
        Arrays.fill(dp2, Integer.MIN_VALUE);

        for (int i = n - 1; i >= 0; i--) {
            dp1[i] = Math.max(dp1[i + 1], arrA[i] - arrB[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1], dp1[i + 1] + arrA[i] - arrB[i]);
        }

        return dp2[0];
     }
}
