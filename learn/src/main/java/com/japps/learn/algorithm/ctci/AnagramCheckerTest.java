/*
 * $Id: AnagramCheckerTest.java 27-Jan-2022 12:24:06 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

import com.japps.learn.util.AnagramChecker;

/**
 * The AnagramCheckerTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AnagramCheckerTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        System.out.println("Test: areAnagrams(): ");
        System.out.println(AnagramChecker.areAnagrams("he12zzZllo@", "HELLOzzz12@"));
        System.out.println(AnagramChecker.areAnagrams("abcd", "dcAb"));
        System.out.println(AnagramChecker.areAnagrams("hello", "hello"));
        System.out.println(AnagramChecker.areAnagrams("1234", "3452"));
        System.out.println(AnagramChecker.areAnagrams("1234", "34521"));
        System.out.println(AnagramChecker.areAnagrams("123 4", "4 231"));

        System.out.println("Test: areAnagramsByBitVector(): ");
        System.out.println(AnagramChecker.areAnagramsByBitVector("he12zzZll@o", "HELL@Ozzz12"));
        System.out.println(AnagramChecker.areAnagramsByBitVector("abcd", "dcAb"));
        System.out.println(AnagramChecker.areAnagramsByBitVector("hello", "hello"));
        System.out.println(AnagramChecker.areAnagramsByBitVector("1234", "3452"));
        System.out.println(AnagramChecker.areAnagramsByBitVector("1234", "34521"));
        System.out.println(AnagramChecker.areAnagramsByBitVector("1 234", "42 31"));

        System.out.println("Test: areAnagramsForEngAlphabet(): ");
        System.out.println(AnagramChecker.areAnagramsForEngAlphabet("nApp", "ppNa"));
        System.out.println(AnagramChecker.areAnagramsForEngAlphabet("ABCD", "dcab"));
        System.out.println(AnagramChecker.areAnagramsForEngAlphabet("hello", "hello"));
        System.out.println(AnagramChecker.areAnagramsForEngAlphabet("rec", "cers"));
        System.out.println(AnagramChecker.areAnagramsForEngAlphabet("AAAPP", "PAAAP"));
        System.out.println(AnagramChecker.areAnagramsForEngAlphabet("SOMME", "SOMEE"));
    }
}
