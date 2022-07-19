/*
 * $Id: SpreadDigitSumEqualizerFirstPageCalculator.java 11-Jul-2022 11:34:45 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jul.rakuten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * The spread digit sum equalizer first page calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class SpreadDigitSumEqualizerFirstPageCalculator {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int t = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < t; t_i++) {
            System.out.println(solve(Integer.parseInt(br.readLine().trim())));
        }

        wr.close();
        br.close();
    }

    /**
     * Solve.
     *
     * @param s the s
     * @return the int
     */
    private static int solve(final int s) {

        if (s == 1) {
            return 1;
        }

        int iterCount = 0;
        int p = 2;
        int currentSum = 1;
        int result;
        while (true) {
            final int sumOfSpreadPageDigits = sumOfSpreadPageDigits(p);
            if (sumOfSpreadPageDigits == s) {
                result = p;
                break;
            }
            currentSum = sumOfSpreadPageDigits;
            if (currentSum > s) {
                iterCount++;
            }
            if (iterCount > 1000) {
                result = -1;
                break;
            }
            p += 2;
        }

        return result;

    }

    /**
     * Sum of spread page digits.
     *
     * @param p the p
     * @return the int
     */
    private static int sumOfSpreadPageDigits(final int p) {

        final int sumOfDigitsOfPage = sumOfDigits(p);
        return 2 * sumOfDigitsOfPage + 1;
    }

    /**
     * Sum of digits.
     *
     * @param n the n
     * @return the int
     */
    private static int sumOfDigits(final int n) {

        int sum, num = n;
        for (sum = 0; num > 0; sum += num % 10, num /= 10)
            ;
        return sum;
    }
}
