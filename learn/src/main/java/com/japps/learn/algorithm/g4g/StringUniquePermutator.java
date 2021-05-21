/*
* $Id: StringPermutator.java 22-Apr-2021 11:48:54 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The string unique permutator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringUniquePermutator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String str = scanner.nextLine();

        final Set<String> strSet = new HashSet<>();
        permute(str, 0, str.length() - 1, strSet);

        strSet.forEach(System.out::println);

        scanner.close();

    }

    /**
     * Permute.
     *
     * @param str the str
     * @param left the left
     * @param right the right
     * @param strSet the str set
     */
    public static void permute(String str, final int left, final int right, final Set<String> strSet) {

        if (left == right) {
            strSet.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                 str = swap(str, left, i);
                 permute(str, left + 1, right, strSet);
                 str = swap(str, left, i);
            }
        }
    }

    /**
     * Swap.
     *
     * @param str the str
     * @param left the left
     * @param right the right
     * @return the string
     */
    private static String swap(final String str, final int left, final int right) {
        final char[] strCharArray = str.toCharArray();
        final char temp = strCharArray[left];
        strCharArray[left] = strCharArray[right];
        strCharArray[right] = temp;

        return String.valueOf(strCharArray);
    }

    /**
     * Permute.
     *
     * @param str the str
     * @param left the left
     * @param right the right
     * @param strSet the str set
     */
    public static void permute(final char[] str, final int left, final int right, final Set<String> strSet) {

        if (left == right) {
            strSet.add(String.join("", Arrays.asList(str).stream().map(x -> String.valueOf(x)).collect(Collectors.toList())));
        } else {
            for (int i = left; i <= right; i++) {
                 swap(str, left, i);
                 permute(str, left + 1, right, strSet);
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
