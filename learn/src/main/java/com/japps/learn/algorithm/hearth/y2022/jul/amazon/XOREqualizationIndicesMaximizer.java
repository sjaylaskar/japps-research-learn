/*
 * $Id: XOREqualizationIndicesMaximizer.java 10-Jul-2022 12:07:58 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jul.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * The XOR equalization indices maximizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class XOREqualizationIndicesMaximizer {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            final int N = Integer.parseInt(br.readLine().trim());
            final String[] arr_A = br.readLine().split(" ");
            final int[] A = new int[N];
            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            final String[] arr_B = br.readLine().split(" ");
            final int[] B = new int[N];
            for (int i_B = 0; i_B < arr_B.length; i_B++) {
                B[i_B] = Integer.parseInt(arr_B[i_B]);
            }

            final int out_ = solve(N, A, B);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    /**
     * Solve.
     *
     * @param n the n
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the int
     */
    private static int solve(final int n, final int[] arr1, final int[] arr2) {

        final int[] xorArr1 = new int[n];
        final int[] xorArr2 = new int[n];

        xorArr1[0] = arr1[0];
        xorArr2[0] = arr2[0];

        for (int i = 1; i < n; i++) {
            xorArr1[i] = xorArr1[i - 1] ^ arr1[i];
            xorArr2[i] = xorArr2[i - 1] ^ arr2[i];
        }

        int maxG = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            int xorArrA = xorArr1[j];
            int xorArrB = xorArr2[j];
            for (int i = 0; i <= j; i++) {
                if (xorArrA == xorArrB) {
                    maxG = Math.max(maxG, j - i + 1);
                }
                xorArrA ^= arr1[i];
                xorArrB ^= arr2[i];
            }
        }

        return (maxG > 0) ? maxG : 0;

    }
}
