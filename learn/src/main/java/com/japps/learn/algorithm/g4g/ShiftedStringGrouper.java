/*
* $Id: ShiftedStringGrouper.java 17-May-2021 7:22:31 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The shifted string grouper.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ShiftedStringGrouper {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        System.out.println(groupShiftedStrings(new String[] {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"}));
    }

    /**
     * Group shifted strings.
     *
     * @param strs the strs
     * @return the list
     */
    private static List<List<String>> groupShiftedStrings(final String[] strs) {

        final Map<String, List<String>> groupsMap = new HashMap<>();

        for (final String str : strs) {
            String key = "";

            for (int i = 1; i < str.length(); i++) {
                int consecutiveCharDiff = str.charAt(i) - str.charAt(i - 1);
                if (consecutiveCharDiff < 0) {
                    consecutiveCharDiff += 26;
                }
                key += (consecutiveCharDiff + 'a');
            }

            //System.out.println("key(" + str + "): " + key);
            groupsMap.putIfAbsent(key, new ArrayList<>());
            groupsMap.get(key).add(str);
        }

        return new ArrayList<>(groupsMap.values());
    }


}
