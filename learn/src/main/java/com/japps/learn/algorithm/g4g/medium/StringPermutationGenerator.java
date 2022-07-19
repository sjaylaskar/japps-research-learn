/*
* $Id: StringPermutationGenerator.java 10-Jul-2022 12:10:32 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The StringPermutationGenerator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringPermutationGenerator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        List<String> permutations = findPermutations("abca");
        permutations.forEach(System.out::println);
        System.out.println("Count: " + permutations.size());

        permutations = findPermutations("abcd");
        permutations.forEach(System.out::println);
        System.out.println("Count: " + permutations.size());
    }

    /**
     * Finds the permutation.
     *
     * @param str the str
     * @return the list
     */
    private static List<String> findPermutations(final String str) {
        final Set<String> permutations = new HashSet<>();
        addPermutations(str, 0, str.length() - 1, permutations);
        return permutations.stream().sorted().collect(java.util.stream.Collectors.toList());
    }

    /**
     * Adds the permutations.
     *
     * @param str the str
     * @param leftIndex the left index
     * @param rightIndex the right index
     * @param permutations the permutations
     */
    private static void addPermutations(String str, final int leftIndex, final int rightIndex, final Set<String> permutations) {
        if (leftIndex == rightIndex) {
            permutations.add(str);
        } else {
            for (int index = leftIndex; index <= rightIndex; index++) {
                str = swap(str, leftIndex, index);
                addPermutations(str, leftIndex + 1, rightIndex, permutations);
                str = swap(str, leftIndex, index);
            }
        }
    }

    /**
     * Swap.
     *
     * @param str the str
     * @param index1 the index 1
     * @param index2 the index 2
     * @return the string
     */
    private static String swap(final String str, final int index1, final int index2) {
        final char[] chars = str.toCharArray();
        final char c = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = c;
        return String.valueOf(chars);
    }
}
