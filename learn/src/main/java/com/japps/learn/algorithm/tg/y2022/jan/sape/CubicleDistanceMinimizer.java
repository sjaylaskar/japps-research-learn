/*
 * $Id: CubicleDistanceMinimizer.java 06-Jan-2022 3:21:03 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jan.sape;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.japps.learn.util.ScannerProvider;


/**
 * The CubicleDistanceMinimizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CubicleDistanceMinimizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {


        try {
            final Scanner scanner = ScannerProvider.instance().scanner();

            final int n = scanner.nextInt();

            scanner.nextLine();

            final char[][] cubicles = new char[n][8];

            int[] managerPos = new int[2];

            final List<int[]> vacantPositions = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                final String row = scanner.nextLine().replace(" ", "");
                for (int j = 0; j < 8; j++) {
                    cubicles[i][j] = row.charAt(j);
                    if (row.charAt(j) == 'M') {
                        managerPos = new int[] {i, j};
                    }
                    if (row.charAt(j) == 'V') {
                        vacantPositions.add(new int[] {i, j});
                    }
                }
            }

            final boolean isManagerPosLeft = isLeft(managerPos[1]);

            int minDistance = Integer.MAX_VALUE;

            for (final int[] vacantPos : vacantPositions) {
                final int horizontalDistance = (isManagerPosLeft ^ isLeft(vacantPos[1]))
                    ? 2
                    : 0;
                final int verticalDistance = Math.abs(managerPos[0] - vacantPos[0]);

                final int distance = horizontalDistance + verticalDistance;

                if (distance < minDistance) {
                    minDistance = distance;
                }
            }

            System.out.println(minDistance);
        } finally {
            ScannerProvider.instance().close();
        }
    }

    /**
     * Checks if is left.
     *
     * @param columnIndex the column index
     * @return true, if is left
     */
    private static boolean isLeft(final int columnIndex) {

        return (columnIndex <= 3);
    }

}
