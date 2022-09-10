/*
 * $Id: ShoeChangeMinimizer.java 26-Jul-2022 9:31:57 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jul.cic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * The ShoeChangeMinimizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ShoeChangeMinimizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final long n = scanner.nextLong();

        final long d = scanner.nextLong();

        scanner.nextLine();

        final List<Integer> temps = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        final long maxNegativeTemps = temps.stream().filter(val -> val < 0).count();

        final boolean isNotPossible = (d < maxNegativeTemps);
        if (!isNotPossible) {
            long changeCount = 0;
            boolean prevLoki = false;
            final long nonNegUsableLoki = d - maxNegativeTemps;
            long nonNegLokiCount = 0;
            for (final long temp : temps) {
                if (temp >= 0) {
                    if (prevLoki) {
                        if (nonNegLokiCount < nonNegUsableLoki) {
                            nonNegLokiCount++;
                        } else {
                            prevLoki = false;
                            changeCount++;
                        }
                    }
                } else {
                    if (!prevLoki) {
                        prevLoki = true;
                        changeCount++;
                    }
                }
            }
            System.out.println(changeCount);
        } else {
            System.out.println("NOT POSSIBLE");
        }

        scanner.close();
    }
}
