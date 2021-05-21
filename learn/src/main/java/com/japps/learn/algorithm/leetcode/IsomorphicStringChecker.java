/*
* $Id: IsomorphicStringChecker.java 11-May-2021 4:42:30 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The isomorphic string checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class IsomorphicStringChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("title", "paper"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    /**
     * Indicates if is isomorphic.
     *
     * @param s the s
     * @param t the t
     * @return {@code true}, if is isomorphic
     */
    private static boolean isIsomorphic(final String s, final String t) {
        //return areIsomorphicByMap(s, t);
        return areIsomorphicByArray(s, t);
    }

    /**
     * Are isomorphic by array.
     *
     * @param s the s
     * @param t the t
     * @return {@code true}, if successful
     */
    private static boolean areIsomorphicByArray(final String s, final String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final char[] charTMappedByS = new char[128];
        final char[] charSMappedByT = new char[128];

        for (int i = 0; i < s.length(); i++) {
            if (charTMappedByS[s.charAt(i)] == 0) {
                if (charSMappedByT[t.charAt(i)] == 0) {
                    charTMappedByS[s.charAt(i)] = t.charAt(i);
                    charSMappedByT[t.charAt(i)] = s.charAt(i);
                } else {
                    return false;
                }
            } else if (charTMappedByS[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Are isomorphic by map.
     *
     * @param s the s
     * @param t the t
     * @return {@code true}, if successful
     */
    private static boolean areIsomorphicByMap(final String s, final String t) {

        if (s.length() != t.length()) {
            return false;
        }

        final Map<Character, Character> charMap = new HashMap<>();
        final Set<Character> targetCharSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            final char cs = s.charAt(i);
            final char ct = t.charAt(i);
            if (charMap.containsKey(cs)) {
                if (!charMap.get(cs).equals(ct)) {
                    return false;
                }
            } else if (targetCharSet.contains(ct)) {
                return false;
            }

            charMap.put(cs, ct);
            targetCharSet.add(ct);
        }

        return true;
    }
}
