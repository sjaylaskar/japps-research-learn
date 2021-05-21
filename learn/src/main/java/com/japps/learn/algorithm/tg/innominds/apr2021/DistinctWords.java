/*
 * $Id: DistinctWords.java 07-Apr-2021 1:35:09 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.innominds.apr2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.japps.learn.util.NumberUtil;


/**
 * The distinct words.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DistinctWords {

    /** The vowels. */
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String s = scanner.next().toUpperCase();

        scanner.close();

        System.out.println(countDistinctWordsStartingWithConsonants(s));
    }

    /**
     * Count distinct words starting with consonants.
     *
     * @param s the s
     * @return the count of distinct words starting with consonants
     */
    private static long countDistinctWordsStartingWithConsonants(final String s) {

        final int n = s.length();

        final Map<Character, Integer> charFrequency = new HashMap<>();

        final long vowelCount = s.chars().filter(c -> VOWELS.contains((char) c)).count();

        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (charFrequency.containsKey(c)) {
                charFrequency.put(c, charFrequency.get(c) + 1);
            } else {
                charFrequency.put(c, 1);
            }
        }

        long repetitions = 1;
        for (final int x : charFrequency.values()) {
            repetitions *= NumberUtil.factorial(x);
        }

        final long nFact = NumberUtil.factorial(n);
        final long nMinusOneFact = nFact / n;



        return (nFact - vowelCount * nMinusOneFact) / repetitions;
    }

}
