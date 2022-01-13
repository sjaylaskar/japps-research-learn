/*
 * $Id: WorkCompletionCalculator.java 04-Jan-2022 9:19:05 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jan.nice;

import java.util.Scanner;


/**
 * The WorkCompletionCalculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class WorkCompletionCalculator {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            final int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                final int c = scanner.nextInt();
                final int d = scanner.nextInt();
                int n = scanner.nextInt();
                final int k = c - d;
                int days = 1;
                while (n > c) {
                    n -= k;
                    days++;
                }
                System.out.println(days);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
