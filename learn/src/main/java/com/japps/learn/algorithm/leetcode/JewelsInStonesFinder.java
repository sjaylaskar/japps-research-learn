/*
* $Id: JewelsInStonesFinder.java 24-May-2021 6:35:45 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * The jewels in stones finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class JewelsInStonesFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));

        System.out.println(numJewelsInStonesByArray("aA", "aAAbbbb"));
        System.out.println(numJewelsInStonesByArray("z", "ZZ"));

        System.out.println(numJewelsInStonesByLoop("aA", "aAAbbbb"));
        System.out.println(numJewelsInStonesByLoop("z", "ZZ"));
    }

    /**
     * Num jewels in stones.
     *
     * @param jewels the jewels
     * @param stones the stones
     * @return the int
     */
    private static int numJewelsInStones(final String jewels, final String stones) {
        return numJewelsInStonesBySet(jewels, stones);
    }

    /**
     * Num jewels in stones by set.
     *
     * @param jewels the jewels
     * @param stones the stones
     * @return the int
     */
    private static int numJewelsInStonesBySet(final String jewels, final String stones) {
        final Set<Character> jewelChars = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelChars.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewelChars.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    /**
     * Num jewels in stones by array.
     *
     * @param jewels the jewels
     * @param stones the stones
     * @return the int
     */
    private static int numJewelsInStonesByArray(final String jewels, final String stones) {
        final char[] jewelChars = new char[52];
        for (int i = 0; i < jewels.length(); i++) {
            final char c = jewels.charAt(i);
            if (Character.isUpperCase(c)) {
                jewelChars[c - 'A' + 26]++;
            } else {
                jewelChars[c - 'a']++;
            }
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            final char c = stones.charAt(i);
            if (Character.isUpperCase(c)) {
                if (jewelChars[c - 'A' + 26] > 0) {
                    count++;
                }
            } else if (jewelChars[c - 'a'] > 0) {
                count++;
            }
        }

        return count;
    }

    /**
     * Num jewels in stones by loop.
     *
     * @param jewels the jewels
     * @param stones the stones
     * @return the int
     */
    private static int numJewelsInStonesByLoop(final String jewels, final String stones) {
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    ++count;
                }
            }
        }

        return count;
    }

}
