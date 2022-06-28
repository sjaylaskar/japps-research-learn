/*
 * Id: CandyShopPriceMinimizer.java 29-Jun-2022 4:46:50 am SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jun.nice;

import java.util.Scanner;
import java.util.stream.LongStream;


public final class CandyShopPriceMinimizer {

    public static void main(final String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            final int n = scanner.nextInt();

            if (n > 0) {

                final int c1 = scanner.nextInt();

                final int c2 = scanner.nextInt();

                System.out.println(
                    LongStream.range(0, n + 1)
                        .map(i -> (c1 * i * i) + (c2 * (n - i) * (n - i)))
                        .boxed().min(Long::compare).get());

            }
        }
        scanner.close();
    }
}
