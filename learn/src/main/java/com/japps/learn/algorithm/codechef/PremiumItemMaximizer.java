/*
 * $Id: PremiumItemMaximizer.java 25-Jul-2022 3:10:16 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * The PremiumItemMaximizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PremiumItemMaximizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        scanner.nextLine();

        for (int test = 1; test <= t; test++) {
            final List<Long> values = Arrays.stream(scanner.nextLine().split(" ")).map(Long::valueOf).collect(Collectors.toList());

            final long x = values.get(0);
            final long y = values.get(1);
            final long n = values.get(2);
            final long r = values.get(3);

            //linearSearchPremiumCountMaximizer(x, y, n, r);

            final long premiumCount = binarySearchPremiumCountMaxmizer(x, y, n, r);
            System.out.println((premiumCount != -1) ? (n - premiumCount) + " " + premiumCount : -1);
        }

        scanner.close();
    }

    /**
     * Linear search premium count maximizer.
     *
     * @param x the x
     * @param y the y
     * @param n the n
     * @param r the r
     */
    private static void linearSearchPremiumCountMaximizer(final long x, final long y, final long n, final long r) {

        long premCount = 0;
        long normalCount = 0;
        for (long i = n; i >= 0; i--) {
            if ((i * y + ((n - i) * x)) <= r) {
                premCount = i;
                normalCount = n - i;
                break;
            }
        }
        if (normalCount == 0 && premCount == 0) {
            System.out.println(-1);
        } else {
            System.out.println(normalCount + " " + premCount);
        }
    }

    /**
     * Binary search premium count maxmizer.
     *
     * @param x the x
     * @param y the y
     * @param n the n
     * @param r the r
     * @return the long
     */
    private static long binarySearchPremiumCountMaxmizer(final long x, final long y, final long n, final long r) {

        long left = 0;
        long right = n;
        long equalPrem = -1;
        long lesserPrem = -1;
        long premCount = -1;
        while (left <= right) {
            final long prem = left + ((right - left) / 2);
            final long cost = prem * y + ((n - prem) * x);
            if (cost < r) {
                lesserPrem = prem;
                left = prem + 1;
            } else if (cost > r) {
                right = prem - 1;
            } else {
                equalPrem = prem;
                break;
            }
        }
        if (equalPrem != -1) {
            premCount = equalPrem;
        } else if (lesserPrem != -1) {
            premCount = lesserPrem;
        }

        return ((premCount != -1) ? premCount : -1);
    }
}
