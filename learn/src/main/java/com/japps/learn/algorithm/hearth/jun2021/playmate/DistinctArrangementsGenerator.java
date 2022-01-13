/*
 * $Id: DistinctArrangementsGenerator.java 23-Jun-2021 3:59:29 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.jun2021.playmate;

import java.util.TreeSet;


/**
 * The distinct arrangements generator.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public class DistinctArrangementsGenerator {

    /** The distinct permutations. */
    private static final TreeSet<String> DISTINCT_PERMUTATIONS = new TreeSet<>();

    /**
     * Permutate.
     *
     * @param str the string
     * @param permutation the permutation
     */
    private static void permutate(final String str, final String permutation) {

        if (str.length() == 0) {

            DISTINCT_PERMUTATIONS.add(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            permutate(str.substring(0, i)
                + str.substring(i + 1), permutation + str.charAt(i));
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        permutate("aba", "");

        DISTINCT_PERMUTATIONS.forEach(System.out::println);

        DISTINCT_PERMUTATIONS.clear();

        permutate("212", "");

        DISTINCT_PERMUTATIONS.forEach(System.out::println);

    }
}
