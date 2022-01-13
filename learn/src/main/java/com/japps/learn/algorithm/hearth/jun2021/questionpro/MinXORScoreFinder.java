/*
 * $Id: MinXORScoreFinder.java 29-Jun-2021 1:11:45 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.jun2021.questionpro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * The MinXORScoreFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MinXORScoreFinder {

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
            int max = -1;
            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
                if (A[i_A] > max) {
                    max = A[i_A];
                }
            }

            final long[] out_ = solve(N, A, max);
            System.out.println(out_[0] + " " + out_[1]);

        }

        wr.close();
        br.close();
    }

    /**
     * Solve.
     *
     * @param n the n
     * @param arr the arr
     * @param max the max
     * @return the long[]
     */
    static long[] solve(final int n, final int[] arr, final int max) {

        long score = Long.MAX_VALUE;

        final Map<Long, Long> fxMap = new HashMap<>();

        for (long x = 0; x <= max; x++) {
            long fx = 0;
            for (int i = 0; i < n; i++) {
                fx += arr[i] ^ x;
            }
            score = Math.min(score, fx);
            fxMap.put(x, fx);
        }

        final long minScore = score;

        return new long[] {minScore, fxMap.entrySet()
            .stream().filter(fx -> fx.getValue().equals(minScore)).count()};

    }

}
