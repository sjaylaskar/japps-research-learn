/*
 * $Id: StringMaxFrequencyLowerASCIICharFinder.java 07-Jun-2022 1:22:28 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jun.sape;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * The StringMaxFrequencyLowerASCIICharFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringMaxFrequencyLowerASCIICharFinder {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= t; testCase++) {
            System.out.println(
                scanner.nextLine().chars().mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .max((a, b) -> a.getValue().intValue() != b.getValue().intValue()
                        ? a.getValue().compareTo(b.getValue())
                        : b.getKey().compareTo(a.getKey())).get());

        }
        scanner.close();
    }

}
