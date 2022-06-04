/*
 * $Id: QuantityFruitMarketMinimizer.java 26-May-2022 12:49:47 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.may.ness;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * The quantity fruit market minimizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class QuantityFruitMarketMinimizer {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(final String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();
        scanner.nextLine();
        final List<Integer> quantities = Arrays.stream(scanner.nextLine().split(" "))
            .map(Integer::valueOf).sorted().collect(Collectors.toList());
        final int quantitySum = quantities.stream().mapToInt(Integer::intValue).sum();
        final int q = scanner.nextInt();

        for (int i = 1; i <= q; i++) {
            long k = scanner.nextLong();
            if (quantitySum < k) {
                System.out.println(-1);
                continue;
            }

            for (int index = 0; index < n; index++) {
                final long remaining = quantities.get(index) * (quantities.size() - index);
                if (remaining < k) {
                    k -= quantities.get(index);
                } else if (remaining > k) {
                    final long minItems = k / (n - index);
                    System.out.println((minItems * (n - index) < k) ? minItems + 1 : minItems);
                    break;
                } else {
                    System.out.println(quantities.get(index));
                    break;
                }
            }
        }

        scanner.close();
    }
}
