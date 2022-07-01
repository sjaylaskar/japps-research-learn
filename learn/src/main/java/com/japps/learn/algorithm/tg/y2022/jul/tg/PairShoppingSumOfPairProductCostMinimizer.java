/*
 * $Id: PairShoppingSumOfPairProductCostMinimizer.java 01-Jul-2022 10:50:24 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jul.tg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
 * The pair shopping sum of pair product cost minimizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PairShoppingSumOfPairProductCostMinimizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {

            final int n = scanner.nextInt();

            final long m = scanner.nextLong();

            scanner.nextLine();

            final List<Long> cropTopPrices = Arrays.stream(scanner.nextLine().split(" "))
                .mapToLong(Long::valueOf)
                .sorted()
                .boxed()
                .toList();

            final List<Long> skirtPrices = Arrays.stream(scanner.nextLine().split(" "))
                .map(Long::valueOf)
                .sorted(Comparator.reverseOrder())
                .toList();

            long cost = 0;
            boolean costExceedsBudget = false;
            for (int priceIndex = 0; priceIndex < n; priceIndex++) {
                if ((cost += (cropTopPrices.get(priceIndex) * skirtPrices.get(priceIndex))) > m) {
                    System.out.println("NO");
                    costExceedsBudget = true;
                    break;
                }
            }
            if (!costExceedsBudget) {
                System.out.println("YES");
            }
        }

        scanner.close();

    }

}
