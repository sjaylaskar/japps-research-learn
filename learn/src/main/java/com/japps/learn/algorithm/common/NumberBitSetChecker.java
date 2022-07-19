/*
* $Id: NumberBitSetChecker.java 20-Jul-2022 12:47:31 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.Scanner;

/**
 * The number bit set checker - checks if the ith bit is set in number n.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NumberBitSetChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(isSetBit(scanner.nextInt(), scanner.nextInt()));

        scanner.close();
    }

    /**
     * Checks if ith bit is set in n.
     *
     * @param n the n
     * @param i the i
     * @return {@code true} if ith bit is set in n.
     */
    private static boolean isSetBit(final int n, final int i) {
        if (i < 0 || i > 31) {
            throw new IllegalArgumentException("Invalid bit position: " + i + ". Integer bits can range from 0 to 31 only.");
        }

        return (n & (1 << i)) > 0;
    }

}
