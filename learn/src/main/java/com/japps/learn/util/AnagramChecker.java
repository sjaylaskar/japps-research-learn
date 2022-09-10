/*
 * Id: AnagramChecker.java 08-Dec-2021 2:28:38 pm SubhajoyLaskar
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

/**
 * The anagram checker.
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class AnagramChecker {

    /**
     * Instantiates a new anagram checker.
     */
    private AnagramChecker() {

    }

    /** The no of chars. */
    private static int NO_OF_CHARS = 256;

    /**
     * Are anagrams for English alphabet.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return true, if successful
     */
    public static boolean areAnagramsForEngAlphabet(final String str1, final String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        final int[] charCount = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            final char c = str1.charAt(i);
            charCount[(('A' <= c && c <= 'Z') ? c + 32 : c) - 97]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            final char c = str2.charAt(i);
            if (--charCount[((('A' <= c && c <= 'Z') ? c + 32 : c) - 97)] < 0) {
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
     * @return true, if successful
     */
    public static boolean areAnagrams(final String str1, final String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        final int[] str1CharsCount = new int[NO_OF_CHARS];

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if ('A' <= c && c <= 'Z') {
                c += 32;
            }
            str1CharsCount[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if ('A' <= c && c <= 'Z') {
                c += 32;
            }
            if (--str1CharsCount[c] < 0) {
                return false;
            }
        }
        return true;
    }



    /**
     * Are anagrams by bit vector.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return true, if successful
     */
    public static boolean areAnagramsByBitVector(final String str1, final String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        int bitVector1 = 0;
        int bitVector2 = 0;

        for (int i = 0; i < str1.length(); i++) {
            bitVector1 ^= (1 << str1.charAt(i));
            bitVector2 ^= (1 << str2.charAt(i));
        }

        return (bitVector1 ^ bitVector2) == 0;
    }
}
