/*
* $Id: FirstUniqueCharacterFinder.java 13-May-2021 3:55:57 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.HashMap;

/**
 * The first unique character finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class FirstUniqueCharacterFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println(firstUniqueCharacter("leetcode"));
        System.out.println(firstUniqueCharacter("loveleetcode"));
        System.out.println(firstUniqueCharacter("aabb"));
        System.out.println(firstUniqueCharacter(null));
        System.out.println(firstUniqueCharacter(""));
    }

    /**
     * First unique character.
     *
     * @param s the s
     * @return the int
     */
    private static int firstUniqueCharacter(final String s) {
        // return firstUniqueCharByMap(s);
        return firstUniqueCharByArray(s);
    }

    /**
     * First unique char by array.
     *
     * @param s the s
     * @return the int
     */
    private static int firstUniqueCharByArray(final String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        final int[] charFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charFreq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * First unique char.
     *
     * @param s the string
     * @return the index of first unique character or -1 if not found
     */
    private static int firstUniqueCharByMap(final String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        final HashMap<Character, Integer> charFrequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charFrequency.put(s.charAt(i), charFrequency.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charFrequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
