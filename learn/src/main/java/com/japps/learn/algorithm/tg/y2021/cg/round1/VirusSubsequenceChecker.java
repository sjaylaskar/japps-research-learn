/*
* $Id: VirusSubsequenceChecker.java 27-Mar-2021 1:25:22 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2021.cg.round1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The virus subsequence checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class VirusSubsequenceChecker {

    /**
     * The blood test result.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private enum BloodTestResult {

        /** The positive. */
        POSITIVE,

        /** The negative. */
        NEGATIVE;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String ...args) {

        final Scanner scanner = new Scanner(System.in);

        final String virusSequence = scanner.nextLine();

        final int numberOfPeopleToTest = scanner.nextInt();

        final List<String> bloodSequences = new ArrayList<>(numberOfPeopleToTest);

        for (int i = 0; i < numberOfPeopleToTest; i++) {
            bloodSequences.add(scanner.next());
        }

        bloodSequences
        .forEach(bloodSequence -> {
            bloodTestResult(bloodSequence, virusSequence);
        });

        scanner.close();
    }

    /**
     * Blood test result.
     *
     * @param bloodSequence the blood sequence
     * @param virusSequence the virus sequence
     */
    private static void bloodTestResult(final String bloodSequence, final String virusSequence) {

       System.out.println((isInfected(bloodSequence, virusSequence)) ? BloodTestResult.POSITIVE : BloodTestResult.NEGATIVE);
    }

    /**
     * Indicates if is infected.
     *
     * @param bloodSequence the blood sequence
     * @param virusSequence the virus sequence
     * @return {@code true}, if is infected
     */
    private static boolean isInfected(final String bloodSequence, final String virusSequence) {

        return isSubSequence(bloodSequence, virusSequence, bloodSequence.length(), virusSequence.length());
    }

    /**
     * Indicates if is sub sequence.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @param str1Length the str 1 length
     * @param str2Length the str 2 length
     * @return {@code true}, if is sub sequence
     */
    private static boolean isSubSequence(final String str1, final String str2, final int str1Length, final int str2Length) {

        //return findIsSubSequenceRecursively(str1, str2, str1Length, str2Length);

        return findIsSubSequenceIteratively(str1, str2, str1Length, str2Length);
    }

    /**
     * Find is sub sequence iteratively.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @param str1Length the str 1 length
     * @param str2Length the str 2 length
     * @return {@code true}, if successful
     */
    private static boolean findIsSubSequenceIteratively(final String str1, final String str2, final int str1Length, final int str2Length) {

        int j = 0;

        for (int i = 0; i < str2Length && j < str1Length; i++) {
             if (str1.charAt(j) == str2.charAt(i)) {
                 j++;
             }
        }

        return (j == str1Length);
    }

    /**
     * Find is sub sequence recursively.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @param str1Length the str 1 length
     * @param str2Length the str 2 length
     * @return {@code true}, if successful
     */
    private static boolean findIsSubSequenceRecursively(final String str1, final String str2, final int str1Length,
            final int str2Length) {

        if (str1Length == 0) {
            return true;
        }

        if (str2Length == 0) {
            return false;
        }

        if (str1.charAt(str1Length - 1) == str2.charAt(str2Length - 1)) {
            return isSubSequence(str1, str2, str1Length - 1, str2Length - 1);
        }

        return isSubSequence(str1, str2, str1Length, str2Length - 1);
    }
}
