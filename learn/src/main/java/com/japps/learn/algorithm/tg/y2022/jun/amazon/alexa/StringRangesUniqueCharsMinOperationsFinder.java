/*
 * $Id: StringRangesUniqueCharsMinOperationsFinder.java 21-Jun-2022 2:24:58 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jun.amazon.alexa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * The StringRangesUniqueCharsMinOperationsFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringRangesUniqueCharsMinOperationsFinder {

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
            final String[] line = br.readLine().split(" ");
            final int n = Integer.parseInt(line[0]);
            final int q = Integer.parseInt(line[1]);
            final String str = br.readLine();
            final String[] arrStr = br.readLine().split(" ");
            final int[] arr = new int[n];
            for (int i_arr = 0; i_arr < arrStr.length; i_arr++) {
                arr[i_arr] = Integer.parseInt(arrStr[i_arr]);
            }
            final int[][] ranges = new int[q][2];
            for (int i_ranges = 0; i_ranges < q; i_ranges++) {
                final String[] arr_ranges = br.readLine().split(" ");
                for (int j_ranges = 0; j_ranges < arr_ranges.length; j_ranges++) {
                    ranges[i_ranges][j_ranges] = Integer.parseInt(arr_ranges[j_ranges]);
                }
            }
            System.out.println(goodString(n, q, str, arr, ranges));
        }

        wr.close();
        br.close();
    }

    /**
     * Good string.
     *
     * @param n the n
     * @param q the q
     * @param s the s
     * @param arr the arr
     * @param ranges the ranges
     * @return the int
     */
    private static int goodString(final int n, final int q, final String s, final int[] arr, final int[][] ranges) {

        final char[] chars = s.toCharArray();

        if (isGoodStringByHashSet(chars, ranges)) {
            return 0;
        }

        int count = 0;
        for (final int index : arr) {
            chars[index - 1] = '_';
            ++count;
            if (isGoodStringForRanges(chars, Arrays.stream(ranges).filter(range -> range[0] <= index && index <= range[1]).toList())) {
                break;
            }
        }

        return count;
    }

    private static boolean isGoodStringForRanges(final char[] chars, final List<int[]> ranges) {
        return IntStream.range(0, ranges.size()).mapToObj(rangeIndex -> ranges.get(rangeIndex))
                .noneMatch(range -> IntStream.range(range[0] - 1, range[1]).mapToObj(index -> chars[index]).filter(value -> !value.equals('_')).collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(frequency -> frequency
                            .getValue() > 1));

    }

    /**
     * Checks if is good string.
     *
     * @param chars the chars
     * @param ranges the ranges
     * @return true, if is good string
     */
    private static boolean isGoodString(final char[] chars, final int[][] ranges) {
        return IntStream.range(0, ranges.length).mapToObj(rangeIndex -> ranges[rangeIndex])
        .noneMatch(range -> IntStream.range(range[0] - 1, range[1]).mapToObj(index -> chars[index]).filter(value -> !value.equals('_')).collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(frequency -> frequency
                    .getValue() > 1));
    }

    /**
     * Checks if is good string by hash set.
     *
     * @param chars the chars
     * @param ranges the ranges
     * @return true, if is good string by hash set
     */
    private static boolean isGoodStringByHashSet(final char[] chars, final int[][] ranges) {
        for (final int[] range : ranges) {
            final Set<Character> charSet = new HashSet<>();
            for (int index = range[0] - 1; index < range[1]; index++) {
                if (chars[index] != '_') {
                    if (!charSet.add(chars[index])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
