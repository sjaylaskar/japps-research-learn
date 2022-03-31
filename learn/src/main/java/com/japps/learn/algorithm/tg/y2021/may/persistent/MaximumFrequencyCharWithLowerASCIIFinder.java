/*
* $Id: MaximumFrequencyCharWithLowerASCIIFinder.java 17-May-2021 3:29:01 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2021.may.persistent;

import java.util.Scanner;

/**
 * The MaximumFrequencyCharWithLowerASCIIFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MaximumFrequencyCharWithLowerASCIIFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            final String s = scanner.next();

            System.out.println(findMaxFrequencyCharWithLowerASCIIValue(s));
        }

        scanner.close();
    }

    /**
     * Find max frequency char with lower ASCII value.
     *
     * @param s the s
     * @return the char
     */
    private static char findMaxFrequencyCharWithLowerASCIIValue(final String s) {

        final char[] charFrequency = new char[26];

        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
        }

        int max = charFrequency[0];
        char maxFreqChar = 'a';
        for (int i = 1; i < 26; i++) {
            if (charFrequency[i] > max) {
                max = charFrequency[i];
                maxFreqChar = (char) (i + 'a');
            }
        }

        return maxFreqChar;
    }

}
