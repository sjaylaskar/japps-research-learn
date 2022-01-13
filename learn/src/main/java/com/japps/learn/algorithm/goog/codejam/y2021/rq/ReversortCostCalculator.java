/*
* $Id: ReversortCostCalculator.java 10-Jan-2022 4:02:20 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.goog.codejam.y2021.rq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * The ReversortCostCalculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ReversortCostCalculator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            final int n = scanner.nextInt();
            final List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(scanner.nextInt());
            }

            int cost = 0;
            for (int p = 0; p < n - 1; p++) {
                final int minIndex = IntStream.range(p, n)
                                        .reduce((x, y) -> list.get(x) > list.get(y) ? y : x)
                                        .getAsInt();
                final List<Integer> posToMinPosSubList = list.subList(p, minIndex + 1);
                Collections.reverse(posToMinPosSubList);
                cost += posToMinPosSubList.size();
            }
            System.out.println("Case #" + i + ": " + cost);
        }

        scanner.close();
    }
}
