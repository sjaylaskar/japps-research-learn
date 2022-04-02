/*
 * $Id: DiceStraightCounter.java 03-Apr-2022 2:57:11 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.goog.codejam.y2022.qualround;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * The dice straight counter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DiceStraightCounter {

    /** The space. */
    private static final String SPACE = " ";

    /** The colon. */
    private static final String COLON = ":";

    /** The case. */
    private static final String CASE = "Case #";

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
            scanner.nextLine();
            final List<Integer> dice = Arrays.asList(scanner.nextLine().split(SPACE))
                .stream().mapToInt(Integer::valueOf).sorted().boxed().collect(Collectors.toList());

            int straightLength = 1;

            for (final Integer dFace : dice) {
                if (dFace >= straightLength) {
                    straightLength++;
                }
            }
            System.out.println(buildCasePrefix(i).append(straightLength - 1));

//            System.out.println(buildCasePrefix(i).append(
//                IntStream
//                    .range(0, n)
//                    .boxed()
//                    .filter(index -> dice.get(index) >= (index + 1))
//                    .count()));

        }

        scanner.close();
    }

    /**
     * Builds the case prefix.
     *
     * @param i the i
     * @return the string builder
     */
    private static StringBuilder buildCasePrefix(final int i) {

        return new StringBuilder(CASE)
            .append(i)
            .append(COLON)
            .append(SPACE);
    }
}
