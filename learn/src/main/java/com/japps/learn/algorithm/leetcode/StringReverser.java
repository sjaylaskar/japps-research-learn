/*
* $Id: StringReverser.java 12-Apr-2021 2:17:03 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.Scanner;

/**
 * The string reverser.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringReverser {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String str = scanner.nextLine();

        scanner.close();

        final char[] strChars = str.toCharArray();
        reverseString(strChars);
        print(strChars);
    }

    /**
     * Reverse string.
     *
     * @param s the s
     */
    private static void reverseString(final char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            final char c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;
        }
    }

    /**
     * Prints the.
     *
     * @param s the s
     */
    private static void print(final char[] s) {
        for (final char c : s) {
            System.out.print(c);
        }
    }
}