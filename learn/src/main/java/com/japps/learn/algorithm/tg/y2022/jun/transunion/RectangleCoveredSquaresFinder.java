/*
 * $Id: RectangleCoveredSquaresFinder.java 14-Jun-2022 2:24:10 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jun.transunion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * The RectangleCoveredSquaresFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class RectangleCoveredSquaresFinder {

    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int t = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < t; t_i++) {
            final int n = Integer.parseInt(br.readLine().trim());
            final Rectangle[] arr = new Rectangle[n];
            for (int i_arr = 0; i_arr < n; i_arr++) {
                final String[] arr_arr = br.readLine().split(" ");
                arr[i_arr] = new Rectangle(Integer.parseInt(arr_arr[0]), Integer.parseInt(arr_arr[1]));
            }

            System.out.println(solve(n, arr));

        }

        wr.close();
        br.close();
    }

    private static long solve(final int n, final Rectangle[] arr) {

        Arrays.sort(arr, (a, b) -> -Long.compare(a.x, b.x));

        final long totalSquares = Arrays.stream(arr).mapToLong(rectangle -> rectangle.x * rectangle.y).sum();

        final long overlappedSquares = IntStream.range(0, n - 1)
            .mapToLong(i -> arr[i + 1].x * Math.min(arr[i].y, arr[i + 1].y))
            .sum();

        return totalSquares - overlappedSquares;

    }

    private static final class Rectangle {

        private final long x;

        private final long y;

        /**
         * @param x
         * @param y
         */
        Rectangle(final long x, final long y) {

            this.x = x;
            this.y = y;
        }

    }
}
