/*
 * $Id: PrefixComparer.java 20-Jan-2022 2:00:43 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jan.sterlite;

import java.util.Scanner;


/**
 * The prefix comparer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PrefixComparer {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(final String args[]) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        final String s = scanner.next();

        final String firstSuffix = s.substring(1, n);

        long greaterCount = firstSuffix.chars().filter(val -> val > s.charAt(0)).count();

        long equalCount = firstSuffix.chars().filter(val -> val == s.charAt(0)).count();

        long smallerCount = firstSuffix.chars().filter(val -> val < s.charAt(0)).count();

        System.out.println(greaterCount + " " + equalCount + " " + smallerCount);

        for (int i = 2; i <= n - 1; i++) {

            final String prefix = s.substring(0, i);
            final int prefixLen = prefix.length();
            greaterCount = 0;
            equalCount = 0;
            smallerCount = 0;
            for (int x = i - prefixLen + 1; x <= n - prefixLen; x++) {
                final String suffix = s.substring(x, x + prefixLen);
                if (suffix.compareTo(prefix) > 0) {
                    greaterCount++;
                } else if (prefix.equals(suffix)) {
                    equalCount++;
                } else {
                    smallerCount++;
                }
            }
            System.out.println(greaterCount + " " + equalCount + " " + smallerCount);
        }

        scanner.close();
    }
}
