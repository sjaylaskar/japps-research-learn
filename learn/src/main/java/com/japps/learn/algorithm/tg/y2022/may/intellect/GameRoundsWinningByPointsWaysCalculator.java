/*
* $Id: GameRoundsWinningByPointsWaysCalculator.java 01-Jun-2022 9:54:20 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.may.intellect;

import java.util.Scanner;

/**
 * The game rounds winning by points ways calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class GameRoundsWinningByPointsWaysCalculator {

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

             final int positionsToFill = r - p;

             final int maxYCoeff = Math.floorDiv(r, p + 1);

             int numberOfWaysToWin = 1;

             for (int yCoeff = 1; yCoeff <= maxYCoeff; yCoeff++) {
                 numberOfWaysToWin += nCr(positionsToFill, yCoeff);
             }
             System.out.println(numberOfWaysToWin % MODULO_PRIME);
        }

        scanner.close();
    }

    private static int nCr(final int n, final int r) {
        if (r == 0) {
            return 1;
        }

        final int nLast = n % MODULO_PRIME;
        final int rLast = r % MODULO_PRIME;

        return (nCr(n / MODULO_PRIME, r / MODULO_PRIME) * nCrModP(nLast, rLast)) % MODULO_PRIME;
    }

    private static int nCrModP(final int n, final int r) {

        final int[] binominalCoeff = new int[r + 1];

        binominalCoeff[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, r); j > 0; j--) {
                binominalCoeff[j] = (binominalCoeff[j] + binominalCoeff[j - 1]) % MODULO_PRIME;
            }
        }

        return binominalCoeff[r];
    }

}
