/*
 * $Id: PalindromePermutationChecker.java 27-Jan-2022 12:46:29 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

/**
 * The PalindromePermutationChecker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PalindromePermutationChecker {

    /** The max chars. */
    private static final int MAX_CHARS = 256;

    /**
     * Checks if is palindrome permutation.
     *
     * @param str the str
     * @return true, if is palindrome permutation
     */
    public boolean isPalindromePermutation(final String str) {

        if (str == null) {
            return false;
        }

        if (str.length() == 0) {
            return true;
        }

        final char[] charsCount = new char[MAX_CHARS];
        int oddFrequencyCount = 0;
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            oddFrequencyCount += (++charsCount[c] % 2 == 1) ? 1 : -1;
        }

        return oddFrequencyCount <= 1;
    }

    /**
     * Checks if is palindrome permutation by bit.
     *
     * @param str the str
     * @return true, if is palindrome permutation by bit
     */
    public boolean isPalindromePermutationByBit(final String str) {

        int bitVector = 0;

        for (int i = 0; i < str.length(); i++) {
            bitVector ^= (1 << str.charAt(i));
        }

        return (bitVector & (bitVector - 1)) == 0;
    }
}
