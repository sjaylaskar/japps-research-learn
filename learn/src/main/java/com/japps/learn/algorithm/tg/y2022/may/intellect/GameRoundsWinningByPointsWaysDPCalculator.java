/*
* $Id: GameRoundsWinningByPointsWaysCalculator.java 01-Jun-2022 9:54:20 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.may.intellect;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The game rounds winning by points ways calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class GameRoundsWinningByPointsWaysDPCalculator {

    private static final int MODULO_PRIME = 1000000007;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        final int[][] winArr = new int[1003][1003];
        Arrays.stream(winArr).forEach(arr -> Arrays.fill(arr, -1));

        for (int testCase = 1; testCase <= t; testCase++) {
             final int r = scanner.nextInt();
             final int p = scanner.nextInt();

             if (r == p) {
                 System.out.println(1);
                 continue;
             }

             System.out.println(calculate(r, p, winArr, 0, 0));
        }

        scanner.close();
    }

    private static int calculate(final int r, final int p, final int[][] winArr, final int coeff, final int x) {
        final int y = coeff - x;

        if (x < (p * y)) {
            return 0;
        }

        if (coeff == r) {
            return 1;
        }

        if (winArr[coeff][x] != -1) {
            return winArr[coeff][x];
        }

        int result = calculate(r, p, winArr, coeff + 1, x + 1)
                   + calculate(r, p, winArr, coeff + 1, x);
        result %= MODULO_PRIME;

        return winArr[coeff][x] = result;
    }
}
