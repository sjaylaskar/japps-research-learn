/*
* $Id: StringCompresser.java 27-Jan-2022 3:49:55 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;


/**
 * The StringCompresser.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringCompresser {

    public static String compressString(final String s) {
        if (s == null || s == "") {
            return s;
        }
        final StringBuilder compressedStringBuilder = new StringBuilder();
        int consecutiveFrequency = 0;
        for (int i = 0; i < s.length(); i++) {
            if (compressedStringBuilder.length() >= s.length()) {
                return s;
            }
            ++consecutiveFrequency;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedStringBuilder.append(s.charAt(i)).append(consecutiveFrequency);
                consecutiveFrequency = 0;
            }
        }
        return (compressedStringBuilder.length() >= s.length()) ? s : compressedStringBuilder.toString();
    }

}
