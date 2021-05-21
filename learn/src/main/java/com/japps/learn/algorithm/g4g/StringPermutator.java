/*
* $Id: StringPermutator.java 22-Apr-2021 11:48:54 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g;

import java.util.Scanner;

/**
 * The string permutator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringPermutator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String str = scanner.nextLine();

        permute(str.toCharArray(), 0, str.length() - 1);

        scanner.close();

    }

    /**
     * Permute.
     *
     * @param str the str
     * @param left the left
     * @param right the right
     */
    private static void permute(final char[] str, final int left, final int right) {

        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                 swap(str, left, i);
                 permute(str, left + 1, right);
                 swap(str, left, i);
            }
        }
    }

    /**
     * Swap.
     *
     * @param str the str
     * @param left the left
     * @param right the right
     */
    private static void swap(final char[] str, final int left, final int right) {
        final char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }

}
