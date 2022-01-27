/*
 * $Id: StringsAreOneApartChecker.java 27-Jan-2022 2:36:58 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

/**
 * The StringsAreOneApartChecker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class StringsAreOneApartChecker {

    /**
     * Are different by one character.
     *
     * @param first the first
     * @param second the second
     * @return true, if successful
     */
    public static boolean areDifferentByOneCharacter(final String first, final String second) {

        if ((first == null && second == null)
            || (first == null && (second != null && second.length() <= 1))
            || (second == null && (first != null && first.length() <= 1))
            || first.equals(second)) {
            return true;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        final int[] chars = new int[256];
        final int maxLen = Math.max(first.length(), second.length());
        for (int i = 0; i < maxLen; i++) {
            if (i < first.length()) {
                chars[first.charAt(i)] = (chars[first.charAt(i)] == 0) ? 1 : 0;
            }
            if (i < second.length()) {
                chars[second.charAt(i)] = (chars[second.charAt(i)] == 0) ? 1 : 0;
            }

        }
        int countOfOne = 0;
        for (final int n : chars) {
            if (countOfOne > 2) {
                return false;
            }
            if (n == 1) {
                countOfOne++;
            }
        }
        return true;
    }

    /**
     * Are one part sequentially.
     *
     * @param first the first
     * @param second the second
     * @return true, if successful
     */
    public static boolean areOnePartSequentially(final String first, final String second) {

        if ((first == null && second == null)
            || (first == null && (second != null && second.length() <= 1))
            || (second == null && (first != null && first.length() <= 1))
            || first.equals(second)) {
            return true;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        final String shortString = (first.length() < second.length()) ? first : second;
        final String longString = (first.length() < second.length()) ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean isDiff = false;
        while (index1 < shortString.length() && index2 < longString.length()) {
            if (shortString.charAt(index1) != longString.charAt(index2)) {
                if (isDiff) {
                    return false;
                }
                isDiff = true;
                if (shortString.length() == longString.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }

        return true;

    }

}
