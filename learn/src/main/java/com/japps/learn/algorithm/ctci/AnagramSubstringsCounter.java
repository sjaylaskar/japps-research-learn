/*
 * $Id: AnagramSubstringsCounter.java 25-Jan-2022 3:56:23 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

import com.japps.learn.util.LogUtil;


/**
 * The AnagramSubstringsCounter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AnagramSubstringsCounter {

    private static final String COUNT_STR = "Count of pattern anagram substrings in text: ";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final AnagramSubstringsCounter anagramSubstringsCounter = new AnagramSubstringsCounter();
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings("cbabadcbbabbcbabaabccbabc", "abbc"));
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings("cbabadcbbabbcbabaabccbabc", ""));
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings("", ""));
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings("", "abcd"));
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings(null, "ancd"));
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings("abcd", null));
        LogUtil.printLn(COUNT_STR, anagramSubstringsCounter.countAnagramSubstrings(null, null));
    }

    /** The max chars. */
    private static final int MAX_CHARS = 256;

    /**
     * Counts the anagram substrings.
     *
     * @param text the text
     * @param pattern the pattern
     * @return the int
     */
    /*
     * T: O(textLen)
     * S: O(1)
     */
    int countAnagramSubstrings(final String text, final String pattern) {

        int textLen = 0;
        int patternLen = 0;
        if (text == null || pattern == null || ((textLen = text.length()) < (patternLen = pattern.length()))) {
            return 0;
        }

        if (textLen < patternLen) {
            return 0;
        }

        int count = 0;

        final char[] countPatternArr = new char[MAX_CHARS];
        final char[] countTextArr = new char[MAX_CHARS];

        for (int i = 0; i < patternLen; i++) {
            countPatternArr[pattern.charAt(i)]++;
            countTextArr[text.charAt(i)]++;
        }

        for (int i = patternLen; i < textLen; i++) {
            if (isFoundAnagram(countTextArr, countPatternArr)) {
                System.out.println("Found at index: " + (i - patternLen));
                ++count;
            }

            countTextArr[text.charAt(i)]++;

            countTextArr[text.charAt(i - patternLen)]--;
        }

        if (isFoundAnagram(countTextArr, countPatternArr)) {
            System.out.println("Found at index: " + (textLen - patternLen));
            ++count;
        }

        return count;
    }

    /**
     * Checks if is found anagram.
     *
     * @param countTextArr the count text arr
     * @param countPatternArr the count pattern arr
     * @return true, if is found anagram
     */
    boolean isFoundAnagram(final char[] countTextArr, final char[] countPatternArr) {

        for (int i = 0; i < MAX_CHARS; i++) {
            if (countTextArr[i] != countPatternArr[i]) {
                return false;
            }
        }
        return true;
    }
}
