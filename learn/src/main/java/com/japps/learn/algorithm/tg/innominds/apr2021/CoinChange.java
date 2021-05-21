/*
* $Id: CoinChange.java 07-Apr-2021 3:10:44 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.innominds.apr2021;

import java.util.Scanner;

/**
 * The coin change.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CoinChange {

    /** The changes. */
    private static final int []COIN_CHANGES = new int[] {1, 2, 5};

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        scanner.close();

        System.out.println(countWaysToPay(n));
    }


    /**
     * Count ways to pay.
     *
     * @param n the n
     * @return the count of ways to pay
     */
    private static int countWaysToPay(final int n) {

        if (n < 12) {
            return 0;
        } else {
            final int []ways = new int[] {3, 2, 1};

            int count = 0;

            while (COIN_CHANGES[2] * ways[2] + COIN_CHANGES[1] * ways[1] + ways[0] <= n) {
                while (true) {
                    ways[0] = n - COIN_CHANGES[2] * ways[2] - COIN_CHANGES[1] * ways[1];
                    if (ways[1] >= ways[0]) {
                        break;
                    }
                    if (ways[0] > ways[1]) {
                        ++count;
                        ways[1]++;
                    }
                }
                ways[2]++;
                ways[1] = ways[2] + 1;
                ways[0] = ways[1] + 1;
            }

            return count;
        }
    }
}
