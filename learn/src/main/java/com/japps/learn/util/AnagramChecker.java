/*
* Id: AnagramChecker.java 08-Dec-2021 2:28:38 pm SubhajoyLaskar
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;


/**
 * The anagram checker.
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
     * Are anagrams.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return {@code true}, if successful
     */
    public static boolean areAnagrams(final String s1, final String s2) {
        final char[] str1 = s1.toCharArray();
        final char[] str2 = s2.toCharArray();

        final int count1[] = new int[NO_OF_CHARS];
        final int count2[] = new int[NO_OF_CHARS];

        for (int i = 0; i < str1.length && i < str2.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        if (str1.length != str2.length)
            return false;

        for (int i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }

}
