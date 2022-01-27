/*
* $Id: AnagramCheckerInputTest.java 12-Apr-2021 2:21:19 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.Scanner;

import com.japps.learn.util.AnagramChecker;

/**
 * The anagram checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AnagramCheckerInputTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String str1 = scanner.nextLine().toLowerCase();

        final String str2 = scanner.nextLine().toLowerCase();

        scanner.close();

        final long startTime = System.currentTimeMillis();
        System.out.println("AnagramChecker.areAnagrams(" + str1 + "," + str2 + "): " + AnagramChecker.areAnagrams(str1, str2));
        final long endTime = System.currentTimeMillis() - startTime;
        System.out.println("AnagramChecker.areAnagrams(): " + endTime + " ms.");

    }
}
