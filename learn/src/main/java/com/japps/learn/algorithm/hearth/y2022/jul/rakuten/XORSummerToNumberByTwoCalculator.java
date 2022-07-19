/*
 * Id: XORSummerToNumberByTwoCalculator.java 11-Jul-2022 10:54:10 pm SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jul.rakuten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * The XOR summer to number by two calculator.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public class XORSummerToNumberByTwoCalculator {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int t = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < t; t_i++) {
            solve(Long.parseLong(br.readLine().trim())).forEach(System.out::println);
        }

        wr.close();
        br.close();
    }

    /**
     * The pair.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     * @param <F> the generic type
     * @param <S> the generic type
     */
    private static final class Pair<F, S> {

        /** The first. */
        private final F first;

        /** The second. */
        private final S second;

        /**
         * Instantiates a new pair.
         *
         * @param first the first
         * @param second the second
         */
        Pair(final F first, final S second) {

            this.first = first;
            this.second = second;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return first + " " + second;
        }
    }

    /**
     * Solve.
     *
     * @param n the n
     * @return the list
     */
    private static List<Pair<Long, Long>> solve(final long n) {

        final List<Pair<Long, Long>> pairs = new ArrayList<>();

        if (n % 2 != 0) {
            pairs.add(new Pair<>(-1L, -1L));
        } else {
            for (long x = 1; x < n / 2; x++) {
                final long nMinusX = n - x;
                if ((2 * xor(x, nMinusX)) == n) {
                    pairs.add(new Pair<>(x, nMinusX));
                }
            }
            if (!pairs.isEmpty()) {
                for (int i = pairs.size() - 1; i >= 0; i--) {
                    pairs.add(new Pair<>(pairs.get(i).second, pairs.get(i).first));
                }
            } else {
                pairs.add(new Pair<>(-1L, -1L));
            }
        }

        return pairs;
    }

    /**
     * Xor.
     *
     * @param x the x
     * @param y the y
     * @return the long
     */
    private static long xor(final long x, final long y) {
        return (x + y - 2 * (x & y));
    }
}
