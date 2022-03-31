/*
 * $Id: MinimumGiftCalculator.java 01-Apr-2022 1:42:14 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.cg.round1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * The minimum gift calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MinimumGiftCalculator {

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

            final int g = scanner.nextInt();

            scanner.nextLine();


              System.out.println(
              Arrays.asList(scanner.nextLine().split(" ")).stream().map(Long::valueOf).sorted().toList().subList(0, n).stream()
              .mapToLong(value -> value).sum());


            System.out.println(
                Arrays.asList(scanner.nextLine().split(" ")).stream().map(Long::valueOf).sorted().collect(Collectors.toList()).subList(0, n).stream()
                    .mapToLong(value -> value).sum());
        }

        scanner.close();
    }

}
