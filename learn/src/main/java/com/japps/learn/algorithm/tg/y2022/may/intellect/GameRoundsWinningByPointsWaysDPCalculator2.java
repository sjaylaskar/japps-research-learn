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
public final class GameRoundsWinningByPointsWaysDPCalculator2 {

    private static final int MODULO_PRIME = 1000000007;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
             final int r = scanner.nextInt();
             final int p = scanner.nextInt();

             if (r == p) {
                 System.out.println(1);
                 continue;
             }

             final int[][] winArr = new int[1003][1003];
             Arrays.stream(winArr).forEach(arr -> Arrays.fill(arr, -1));

             System.out.println("\nResult: " + calculate(r, p, winArr, p, 0));
        }

        scanner.close();
    }

    private static int calculate(final int r, final int p, final int[][] winArr, final int x, final int y) {
        if (winArr[x][y] != -1) {
            return winArr[x][y];
        }

        if (x < (p * y)) {
            return 0;
        }

        if (x + y == r) {
            return 1;
        }

        winArr[x][y] = (calculate(r, p, winArr, x + 1, y) % MODULO_PRIME
                   + calculate(r, p, winArr, x, y + 1) % MODULO_PRIME) % MODULO_PRIME;
        System.out.print(winArr[x][y] + ";");
        return winArr[x][y] % MODULO_PRIME;
    }
}
