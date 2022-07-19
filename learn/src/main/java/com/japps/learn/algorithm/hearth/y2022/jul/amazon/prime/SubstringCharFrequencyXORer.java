/*
 * $Id: SubstringCharFrequencyXORer.java 18-Jul-2022 12:52:31 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jul.amazon.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * The SubstringCharFrequencyXORer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SubstringCharFrequencyXORer {

    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            final String S = br.readLine();
            final int Q = Integer.parseInt(br.readLine().trim());
            final int[][] queries = new int[Q][3];
            for (int i_queries = 0; i_queries < Q; i_queries++) {
                final String[] arr_queries = br.readLine().split(" ");
                for (int j_queries = 0; j_queries < arr_queries.length; j_queries++) {
                    queries[i_queries][j_queries] = Integer.parseInt(arr_queries[j_queries]);
                }
            }

            System.out.println(substringScore(S, Q, queries).stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

        wr.close();
        br.close();
    }

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private static List<Long> substringScore(final String s, final int q, final int[][] queries) {

        final List<Long> scores = new ArrayList<>();
        final char[] chars = s.toCharArray();
        for (final int[] query : queries) {
            switch (query[0]) {
            case 1:
                scores.add(xorFrequency(chars, query[1] - 1, query[2]));
            case 2:
                chars[query[1] - 1] = alphabet.charAt(query[2] - 1);
                break;
            }
        }
        return scores;
    }

    private static long xorFrequency(final char[] chars, final int startIndex, final int endIndex) {

        final Map<Character, Long> frequencyMap = IntStream.range(startIndex, endIndex).mapToObj(i -> chars[i]).collect(Collectors
            .groupingBy(Function.identity(), Collectors.counting()));
        long xorFreq = 0;
        for (final Long freq : frequencyMap.values()) {
            xorFreq ^= freq;
        }
        return xorFreq;
    }
}
