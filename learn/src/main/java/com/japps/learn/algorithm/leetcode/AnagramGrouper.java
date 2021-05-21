/*
 * $Id: AnagramGrouper.java 17-May-2021 12:18:49 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * The anagram grouper.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AnagramGrouper {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        long start = System.currentTimeMillis();

        System.out.println(groupAnagramsByMap(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagramsByMap(new String[] {}));
        System.out.println(groupAnagramsByMap(new String[] {""}));
        System.out.println(groupAnagramsByMap(new String[] {"a"}));
        System.out.println(groupAnagramsByMap(new String[] {"are", "code", "ear", "bat", "tab", "era"}));
        System.out.println(groupAnagramsByMap(new String[] {"aab", "aba", "baa", "acc", "abbccc", "cac"}));

        System.out.println("groupAnagramsByMap() overall: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("=======================================================================");

        start = System.currentTimeMillis();
        System.out.println(groupAnagramsByStreams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagramsByStreams(new String[] {}));
        System.out.println(groupAnagramsByStreams(new String[] {""}));
        System.out.println(groupAnagramsByStreams(new String[] {"a"}));
        System.out.println(groupAnagramsByStreams(new String[] {"are", "code", "ear", "bat", "tab", "era"}));
        System.out.println(groupAnagramsByStreams(new String[] {"aab", "aba", "baa", "acc", "abbccc", "cac"}));
        System.out.println("groupAnagramsByStreams() overall: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("=======================================================================");

        start = System.currentTimeMillis();
        System.out.println(groupAnagramsBySorting(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagramsBySorting(new String[] {}));
        System.out.println(groupAnagramsBySorting(new String[] {""}));
        System.out.println(groupAnagramsBySorting(new String[] {"a"}));
        System.out.println(groupAnagramsBySorting(new String[] {"are", "code", "ear", "bat", "tab", "era"}));
        System.out.println(groupAnagramsBySorting(new String[] {"aab", "aba", "baa", "acc", "abbccc", "cac"}));
        System.out.println("groupAnagramsBySorting() overall: " + (System.currentTimeMillis() - start) + " ms");

    }

    /**
     * Group anagrams by map.
     *
     * @param strs the strs
     * @return the list
     */
    private static List<List<String>> groupAnagramsByMap(final String[] strs) {

        if (strs.length == 0) {
            return new ArrayList<>();
        }

        if (strs.length == 1) {
            final List<List<String>> groups = new ArrayList<>();
            groups.add(new ArrayList<>());
            groups.get(0).add(strs[0]);
            return groups;
        }

        final Map<String, List<String>> groupsMap = new HashMap<>();

        final int[] charFreq = new int[26];

        for (final String str : strs) {
            //final int[] charFreq = new int[26];
            Arrays.fill(charFreq, 0);

            for (int i = 0; i < str.length(); i++) {
                charFreq[str.charAt(i) - 'a']++;
            }

            final StringBuilder keyStringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {

                if (charFreq[i] != 0) {
                    keyStringBuilder.append((char) (i + 'a')).append(charFreq[i]);
                }

                // keyStringBuilder.append("#").append(charFreq[i]);
            }

            final String key = keyStringBuilder.toString();
            groupsMap.putIfAbsent(key, new ArrayList<>());
            groupsMap.get(key).add(str);
            // groupsMap.computeIfAbsent(keyStringBuilder.toString(), z -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groupsMap.values());
    }

    /**
     * Group anagrams by streams.
     *
     * @param strs the strs
     * @return the list
     */
    private static List<List<String>> groupAnagramsByStreams(final String[] strs) {

        return new ArrayList<>(Stream.of(strs)
            .collect(Collectors.groupingBy(str -> str.chars().boxed().sorted().collect(Collectors.toList()))).values());
    }

    /**
     * Group anagrams by sorting.
     *
     * @param strs the strs
     * @return the list
     */
    private static List<List<String>> groupAnagramsBySorting(final String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        if (strs.length == 1) {
            final List<List<String>> groups = new ArrayList<>();
            groups.add(new ArrayList<>());
            groups.get(0).add(strs[0]);
            return groups;
        }

        final Map<String, List<String>> groupsMap = new HashMap<>();

        for (final String str : strs) {
            final char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            final String sortedStr = String.valueOf(strChars);
            groupsMap.putIfAbsent(sortedStr, new ArrayList<>());
            groupsMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(groupsMap.values());
    }
}
