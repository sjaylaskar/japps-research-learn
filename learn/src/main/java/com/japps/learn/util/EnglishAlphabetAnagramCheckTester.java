/*
 * Id: EnglishAlphabetAnagramCheckTester.java 08-Dec-2021 2:28:38 pm SubhajoyLaskar
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

/**
 * The English alphabet anagram checker.
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class EnglishAlphabetAnagramCheckTester {

    /**
     * Instantiates a new anagram checker.
     */
    private EnglishAlphabetAnagramCheckTester() {

    }

    /** The number of characters in the alphabet. */
    private static int NO_OF_CHARS = 26;

    /**
     * Are anagrams for English alphabet.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return true, if successful
     */
    public static boolean areAnagramsForEngAlphabet(final String str1, final String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null && str2 != null
            || str1 != null && str2 == null
            || str1.length() != str2.length()) {
            return false;
        }
        final int[] charCount = new int[NO_OF_CHARS];

        for (int i = 0; i < str1.length(); i++) {
            final char c = str1.charAt(i);
            charCount[determineCharIndex(c)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            final char c = str2.charAt(i);
            if (--charCount[determineCharIndex(c)] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines the char index.
     *
     * @param c the character
     * @return the index
     */
    private static int determineCharIndex(final char c) {

        return (('A' <= c && c <= 'Z') ? c + 32 : c) - 97;
    }

    /**
     * The main test for the anagram check.
     *
     * @param args The arguments.
     */
    public static void main(final String[] args) {

        System.out.println(areAnagramsForEngAlphabet(null, null));
        System.out.println(areAnagramsForEngAlphabet("", null));
        System.out.println(areAnagramsForEngAlphabet(null, ""));
        System.out.println(areAnagramsForEngAlphabet(null, "abc"));
        System.out.println(areAnagramsForEngAlphabet("abc", null));
        System.out.println(areAnagramsForEngAlphabet("abcd", "abc"));
        System.out.println(areAnagramsForEngAlphabet("bac", "abc"));
        System.out.println(areAnagramsForEngAlphabet("MAPp", "ppAm"));
        System.out.println(areAnagramsForEngAlphabet("XYZTRE", "RETYZX"));
        System.out.println(areAnagramsForEngAlphabet("XXXYYY", "YYXXWW"));
    }
}
