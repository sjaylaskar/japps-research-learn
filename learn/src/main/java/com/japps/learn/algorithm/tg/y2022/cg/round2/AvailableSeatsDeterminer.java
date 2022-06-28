/*
 * Id: AvailableSeatsDeterminer.java 27-Jun-2022 11:34:29 pm SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.cg.round2;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


/**
 * The available seats determiner.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class AvailableSeatsDeterminer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final long s = scanner.nextLong();

        final long t = scanner.nextLong();

        final long q = scanner.nextLong();

        final Set<Long> occupiedSeats =
            LongStream.range(1, t + 1)
            .map(index -> scanner.nextLong()).boxed().collect(Collectors.toSet());

        try {
            LongStream.range(1, q + 1)
                .forEach(index -> System.out.println((occupiedSeats.contains(scanner.nextLong())) ? "N" : "Y"));
        } catch (final Exception exception) {
            System.out.println("Y");
        }

        scanner.close();
    }
}
