/*
 * $Id: MatrixElementsGCDOneizer.java 01-Jun-2022 9:52:37 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.may.adpushup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * The MatrixElementsGCDOneizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MatrixElementsGCDOneizer {

    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int t = Integer.parseInt(br.readLine());

        for (int t_i = 0; t_i < t; t_i++) {

            final StringTokenizer st = new StringTokenizer(br.readLine());

            final int n = Integer.parseInt(st.nextToken());
            final int m = Integer.parseInt(st.nextToken());

            final int mat[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                final StringTokenizer ste = new StringTokenizer(br.readLine());

                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(ste.nextToken());
                }
            }

            final int ans = solve(n, m, mat);
            System.out.println(ans);
        }
    }

    private static int solve(final int n, final int m, final int mat[][]) {

        if (n == 1 && m == 1) {
            return (mat[0][0] != 1) ? 1 : 0;
        }
        if (n == 1) {
            return (int) Arrays.stream(mat[0])
                .filter(val -> val != 1)
                .count();
        }
        if (m == 1) {
            int minOpsCount = 0;
            for (int row = 0; row < n; row++) {
                if (mat[row][0] != -1) {
                    ++minOpsCount;
                }
            }
            return minOpsCount;
        }

        int invalidRowsCount = 0;
        for (int row = 0; row < n; row++) {
            int rowGCD = calcGCD(mat[row][0], mat[row][1]);
            for (int col = 2; col < m; col++) {
                rowGCD = calcGCD(rowGCD, mat[row][col]);
            }
            if (rowGCD != 1) {
                invalidRowsCount++;
            }
        }

        int invalidColsCount = 0;
        for (int col = 0; col < m; col++) {
            int colGCD = calcGCD(mat[0][col], mat[1][col]);
            for (int row = 2; row < n; row++) {
                colGCD = calcGCD(colGCD, mat[row][col]);
            }
            if (colGCD != 1) {
                invalidColsCount++;
            }
        }

        return Math.max(invalidRowsCount, invalidColsCount);
    }

    private static int calcGCD(final int n1, final int n2) {

        return (n1 == n2) ? n1 : (n1 > n2) ? gcd(n1, n2) : gcd(n2, n1);
    }

    private static int gcd(final int n1, final int n2) {

        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
