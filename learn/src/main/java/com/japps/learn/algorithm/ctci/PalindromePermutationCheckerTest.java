/*
* $Id: PalindromePermutationCheckerTest.java 27-Jan-2022 12:47:49 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;


/**
 * The PalindromePermutationCheckerTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PalindromePermutationCheckerTest {

    public static void main(final String[] args) {

        final PalindromePermutationChecker palindromePermutationChecker = new PalindromePermutationChecker();

        System.out.println(palindromePermutationChecker.isPalindromePermutation("mad d d adm 123 3 4  21"));
        System.out.println(palindromePermutationChecker.isPalindromePermutation("madamde  f 576"));

        System.out.println(palindromePermutationChecker.isPalindromePermutationByBit("mad d d adm 123 3 4  21"));
        System.out.println(palindromePermutationChecker.isPalindromePermutationByBit("madamde f 123"));
    }
}
