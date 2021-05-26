/*
 * $Id: LengthOfLongestSubstringWithoutRepeatingCharsFinder.java 24-May-2021 3:34:57 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * The length of longest substring without repeating chars finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LengthOfLongestSubstringWithoutRepeatingCharsFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstring("abcaqwqwqwewdscscsgsfsfffffffffffffffwwewewe2222222sdsd22343545464524242421111234567890pqrstuvwxyzbcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("s"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("xyxt"));
        System.out.println(lengthOfLongestSubstring("wobgrovw"));
        System.out.println(lengthOfLongestSubstring("abcaqwtttttttttttttttttttqwererqwqxsxzxweewxsxzdsdwesxzxdsddsssdsdsdswewwdshdsjdhsjdhsjdhsjhdsdshdjshqwertyuiopasdfghjklmznxbcv1234567777888888999086125162516214615371673jfjqwqwewdscscsgsfsfffffffffffffffwwewewe2222222sdsd22343545464524242421111234567890pqrstuvwxyzbcbb"));
        System.out.println("1: " + (System.currentTimeMillis() - start) + " ms.");

        System.out.println("==================================================================");

        start = System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("abcaqwqwqwewdscscsgsfsfffffffffffffffwwewewe2222222sdsd22343545464524242421111234567890pqrstuvwxyzbcbb"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("bbbbb"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("s"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("pwwkew"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2(""));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2(" "));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("au"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("xyxt"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("wobgrovw"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2("abcaqwtttttttttttttttttttqwererqwqxsxzxweewxsxzdsdwesxzxdsddsssdsdsdswewwdshdsjdhsjdhsjdhsjhdsdshdjshqwertyuiopasdfghjklmznxbcv1234567777888888999086125162516214615371673jfjqwqwewdscscsgsfsfffffffffffffffwwewewe2222222sdsd22343545464524242421111234567890pqrstuvwxyzbcbb"));
        System.out.println("2: " + (System.currentTimeMillis() - start) + " ms.");

        System.out.println("==================================================================");

        start = System.currentTimeMillis();
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("abcaqwqwqwewdscscsgsfsfffffffffffffffwwewewe2222222sdsd22343545464524242421111234567890pqrstuvwxyzbcbb"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("bbbbb"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("s"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("pwwkew"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable(""));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable(" "));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("au"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("xyxt"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("wobgrovw"));
        System.out.println(lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable("abcaqwtttttttttttttttttttqwererqwqxsxzxweewxsxzdsdwesxzxdsddsssdsdsdswewwdshdsjdhsjdhsjdhsjhdsdshdjshqwertyuiopasdfghjklmznxbcv1234567777888888999086125162516214615371673jfjqwqwewdscscsgsfsfffffffffffffffwwewewe2222222sdsd22343545464524242421111234567890pqrstuvwxyzbcbb"));
        System.out.println("2: " + (System.currentTimeMillis() - start) + " ms.");

    }

    /**
     * Length of longest substring.
     *
     * @param str the string
     * @return the length
     */
    private static int lengthOfLongestSubstring(final String str) {

        //return lengthOfLongestSubstringWithoutRepeatingCharsByMap(str);
        return lengthOfLongestSubstringWithoutRepeatingCharsByCharTable(str);
    }

    /**
     * Length of longest substring without repeating chars by map.
     *
     * @param str the str
     * @return the int
     */
    private static int lengthOfLongestSubstringWithoutRepeatingCharsByMap(final String str) {
        int result = 0;

        final Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0, j = 0; j < str.length(); j++) {
             if (charIndexMap.containsKey(str.charAt(j))) {
                 i = Math.max(charIndexMap.get(str.charAt(j)), i);
             }
             result = Math.max(result, j - i + 1);
             charIndexMap.put(str.charAt(j), j + 1);
        }

        return result;
    }

    /**
     * Length of longest substring without repeating chars by char table.
     *
     * @param str the str
     * @return the int
     */
    private static int lengthOfLongestSubstringWithoutRepeatingCharsByCharTable(final String str) {
        int left = 0, right = 0, result = 0;
        final Integer[] chars = new Integer[128];

        while (right < str.length()) {
            final char c = str.charAt(right);
            final Integer index = chars[c];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }
            result = Math.max(result, right - left + 1);
            chars[c] = right++;
        }

        return result;
    }

    /**
     * Length of longest substring without repeating chars by char table 2.
     *
     * @param str the str
     * @return the int
     */
    private static int lengthOfLongestSubstringWithoutRepeatingCharsByCharTable2(final String str) {
        int left = 0, right = 0, result = 0;
        final Integer[] chars = new Integer[128];

        while (right < str.length()) {
            final Integer index = chars[str.charAt(right)];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }
            result = Math.max(result, right - left + 1);
            chars[str.charAt(right)] = right++;
        }

        return result;
    }

    /**
     * Length of longest substring without repeating chars by smaller char table.
     *
     * @param s the s
     * @return the int
     */
    private static int lengthOfLongestSubstringWithoutRepeatingCharsBySmallerCharTable(final String s) {
        int result = 0, count = 0, visitedIndexForChar = 1;

        final int[] chars = new int[95];

        for (int i = 0; i < s.length(); i++) {
            final int c = s.charAt(i) - 32;

            if (chars[c] >= visitedIndexForChar) {
                result = Math.max(result, count);

                visitedIndexForChar = chars[c];

                count = i - visitedIndexForChar + 1;
            } else {
                count++;
            }

            chars[c] = i + 1;
        }

        return Math.max(result, count);
    }

}
