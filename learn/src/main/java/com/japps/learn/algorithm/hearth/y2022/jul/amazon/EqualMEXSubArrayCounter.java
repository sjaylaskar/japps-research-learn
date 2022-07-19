/*
 * $Id: EqualMEXSubArrayCounter.java 10-Jul-2022 12:08:51 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jul.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * The equal MEX sub array counter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class EqualMEXSubArrayCounter {

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

            final int out_ = solve(N, A);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    /**
     * Solve.
     *
     * @param n the n
     * @param arr the arr
     * @return the int
     */
    private static int solve(final int n, final int[] arr) {

        final int count = 1;



        return count;
    }
}
