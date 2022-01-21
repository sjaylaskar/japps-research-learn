/*
* $Id: AbsenteesCounter.java 21-Jan-2022 5:25:04 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.jan.experion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * The AbsenteesCounter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AbsenteesCounter {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        scanner.nextLine();

        final String[] rollSetArr = scanner.nextLine().split(" ");

        final Set<Integer> rollSet = new HashSet<>();

        for (final String rollStr : rollSetArr) {
            rollSet.add(Integer.parseInt(rollStr));
        }

        IntStream.range(1, n + 1).filter(x -> !rollSet.contains(x)).sorted().forEach(val -> System.out.print(val + " "));

        scanner.close();
    }

}
