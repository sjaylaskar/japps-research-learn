/*
 * $Id: DeviceSwitchCounter.java 21-Jan-2022 3:18:56 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jan.clervertap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * The DeviceSwitchCounter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DeviceSwitchCounter {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int n = Integer.parseInt(br.readLine().trim());
        final int[] websiteVisits = new int[n];
        for (int i_websiteVisits = 0; i_websiteVisits < n; i_websiteVisits++) {
            final int temp = Integer.parseInt(br.readLine().trim());
            websiteVisits[i_websiteVisits] = temp;
        }
        final int m = Integer.parseInt(br.readLine().trim());
        final int[] appVisits = new int[m];
        for (int i_appVisits = 0; i_appVisits < m; i_appVisits++) {
            final int temp = Integer.parseInt(br.readLine().trim());
            appVisits[i_appVisits] = temp;
        }

        final int out_ = computeDeviceCrossovers(n, websiteVisits, m, appVisits);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    /**
     * Compute device crossovers.
     *
     * @param n the n
     * @param websiteVisits the website visits
     * @param m the m
     * @param appVisits the app visits
     * @return the int
     */
    private static int computeDeviceCrossovers(final int n, final int[] websiteVisits, final int m, final int[] appVisits) {

        if (n == 0 || m == 0) {
            return 0;
        }

        int result = 0;

        final int[] firstArr = websiteVisits[0] < appVisits[0] ? websiteVisits : appVisits;
        final int[] secondArr = websiteVisits[0] > appVisits[0] ? websiteVisits : appVisits;

        int x = 1;
        int y = 0;
        int curr = 1;
        whileLoop: while (true) {
            if (x > firstArr.length - 1) {
                if (y > secondArr.length - 1) {
                    break;
                } else {
                    for (int k = y; k < secondArr.length; k++) {
                        if (firstArr[firstArr.length - 1] < secondArr[k]) {
                            result++;
                            break whileLoop;
                        }
                    }
                }
            }
            if (y > secondArr.length - 1) {
                if (x > firstArr.length - 1) {
                    break;
                } else {
                    for (int k = x; k < secondArr.length; k++) {
                        if (secondArr[secondArr.length - 1] < firstArr[k]) {
                            result++;
                            break whileLoop;
                        }
                    }
                }
            }

            if (firstArr[x] < secondArr[y]) {
                if (curr == 2) {
                    curr = 1;
                    result++;
                }
                x++;
            } else {
                if (curr == 1) {
                    curr = 2;
                    result++;
                }
                y++;
            }
        }

        return result;

    }
}
