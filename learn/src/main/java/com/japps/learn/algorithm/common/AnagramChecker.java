/*
* $Id: AnagramChecker.java 12-Apr-2021 2:21:19 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The anagram checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AnagramChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String str1 = scanner.nextLine().toLowerCase();

        final String str2 = scanner.nextLine().toLowerCase();

        scanner.close();

        long startTime = System.currentTimeMillis();
        System.out.println("areAnagramsByArrayCache(" + str1 + "," + str2 + "): " + areAnagramsByArrayCache(str1, str2));
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("areAnagrams() check by array cache: " + endTime + " ms.");

        startTime = System.currentTimeMillis();
        System.out.println("areAnagrams(" + str1 + "," + str2 + "): " + areAnagrams(str1, str2));
        endTime = System.currentTimeMillis() - startTime;
        System.out.println("areAnagrams() check by hashmap and alphabet loop time: " + endTime + " ms.");

    }

    /**
     * Are anagrams.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return {@code true}, if successful
     */
    private static boolean areAnagramsByArrayCache(final String str1, final String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        final char[] str1CharFrequency = new char[26];
        final char[] str2CharFrequency = new char[26];

        for (int i = 0; i < str1.length(); i++) {
            str1CharFrequency[str1.charAt(i) - 'a']++;
            str2CharFrequency[str2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (str1CharFrequency[i] != str2CharFrequency[i]) {
                return false;
            }
        }


        return true;
    }

    /**
     * Are anagrams.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return {@code true}, if successful
     */
    private static boolean areAnagrams(final String str1, final String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        final Map<Character, Integer> str1CharFrequency = new HashMap<>();
        final Map<Character, Integer> str2CharFrequency = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            str1CharFrequency.put(c, 0);
            str2CharFrequency.put(c, 0);
            for (int i = 0; i < str1.length(); i++) {
                if (c == str1.charAt(i)) {
                    str1CharFrequency.put(c, str1CharFrequency.get(c) + 1);
                }
                if (c == str2.charAt(i)) {
                    str2CharFrequency.put(c, str2CharFrequency.get(c) + 1);
                }
            }
            if (Integer.compare(str1CharFrequency.get(c), str2CharFrequency.get(c)) != 0) {
                return false;
            }
        }

        return true;
    }
}
