/*
 * $Id: XOROperations.java 14-Jun-2022 2:42:57 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jun.transunion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The XOROperations.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class XOROperations {

    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int t = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < t; t_i++) {
            final int q = Integer.parseInt(br.readLine().trim());
            final String[] arr_type = br.readLine().split(" ");
            final int[] type = new int[q];
            for (int i_type = 0; i_type < arr_type.length; i_type++) {
                type[i_type] = Integer.parseInt(arr_type[i_type]);
            }
            final String[] arr_X = br.readLine().split(" ");
            final long[] xArr = new long[q];
            for (int i_X = 0; i_X < arr_X.length; i_X++) {
                xArr[i_X] = Long.parseLong(arr_X[i_X]);
            }

            final List<Long> out_ = solve(q, type, xArr);
            System.out.print(out_.get(0));
            out_.subList(1, out_.size()).forEach(result -> System.out.print(" " + result));
            System.out.println();

        }

        wr.close();
        br.close();
    }

    private static List<Long> solve(final int q, final int[] type, final long[] xArr) {
        /*
         * Q: Number of queries
         * type: array denoting the type of each query
         * X:
         * array denoting parameter of each query
         */

        final List<Long> result = new ArrayList<>();
        final Map<Long, Long> numbers = new HashMap<>();
        for (int i = 0; i < q; i++) {
            switch (type[i]) {
            case 1 -> numbers.put(xArr[i], numbers.getOrDefault(xArr[i], 0L) + 1);
            case 2 -> numbers.remove(xArr[i]);
            case 3 -> {
                final long xorer = xArr[i];
                result.add(numbers.entrySet().stream().filter(numberEntry -> numberEntry.getKey() != xorer).map(
                    numberEntry -> numberEntry.getValue() * (numberEntry.getKey() ^ xorer))
                    .mapToLong(Long::valueOf).sum());
            }
            }
        }

        return result;

    }
}
