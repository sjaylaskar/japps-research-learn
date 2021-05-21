/*
* $Id: LongestSubstringWithAtMostKDistinctCharsByQueries.java 10-May-2021 3:01:22 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.may2021.amazon;

import java.util.HashSet;

/**
 * The longest substring with at most K distinct chars by queries.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LongestSubstringWithAtMostKDistinctCharsByQueries {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        calculate("aeeorr", new int[] {1, 4, 5});
    }

    /**
     * Calculate.
     *
     * @param str the str
     * @param queries the queries
     * @return the int
     */
    private static int calculate(final String str, final int[] queries) {

        final int max = 0;

        String subStr = new String(str);

        final HashSet<String> subStrSet = new HashSet<>();
        for (final int query : queries) {
            System.out.println("Query: " + query);
            for (int j = 0; j < query; j++) {
                for (int x = 0; x < subStr.length() - 1; x++) {
                    for (int y = x + 1; y < subStr.length(); y++) {
                        subStr = subStr.substring(0, x + 1)
                                 + new StringBuilder(subStr.substring(x + 1, y + 1)).reverse()
                                 + subStr.substring(y + 1, subStr.length());
                        if (subStrSet.add(subStr)) {
                            System.out.println(subStr);
                        }
                    }
                }
            }
            System.out.println("==================================================================");
        }


        return max;
    }
}
