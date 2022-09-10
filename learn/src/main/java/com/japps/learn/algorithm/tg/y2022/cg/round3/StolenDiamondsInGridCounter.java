/*
 * $Id: StolenDiamondsInGridCounter.java 24-Jul-2022 1:22:41 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.cg.round3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * The stolen diamonds in grid counter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StolenDiamondsInGridCounter {

    /** The directions. */
    private static final Map<Character, Character> DIRECTIONS = new HashMap<>(20);

    static {
        DIRECTIONS.put('A', 'E');
        DIRECTIONS.put('U', 'W');
        DIRECTIONS.put('J', 'N');
        DIRECTIONS.put('P', 'S');
        final char[] dirStarts = new char[] {'A', 'U', 'J', 'P'};
        for (final char character : dirStarts) {
            final char start = (char) (character + 1);
            final char end = (char) (start + 3);
            for (char c = start; c <= end; c++) {
                DIRECTIONS.put(c, DIRECTIONS.get(character));
            }
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(final String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        scanner.nextLine();

        for (int test = 1; test <= t; test++) {
            final String[] nmPairStrArr = scanner.nextLine().split(" ");
            final int n = Integer.parseInt(nmPairStrArr[0]);
            final int m = Integer.parseInt(nmPairStrArr[1]);

            final int d = scanner.nextInt();

            final boolean[][] grid = new boolean[m][n];

            for (int diamCount = 1; diamCount <= d; diamCount++) {
                grid[scanner.nextInt() - 1][scanner.nextInt() - 1] = true;
            }

            final int movesMade = scanner.nextInt();

            int diamondsStolen = 0;

            int x = 0;
            int y = 0;

            diamondsStolen = updateGridDiamonds(grid, diamondsStolen, x, y);

            if (movesMade > 0) {
                scanner.nextLine();

                for (int move = 1; move <= movesMade; move++) {
                    final char moveDir = scanner.nextLine().charAt(0);
                    if (!DIRECTIONS.containsKey(moveDir)) {
                        continue;
                    }
                    final char direction = DIRECTIONS.get(moveDir);
                    switch (direction) {
                    case 'E':
                        if (x < m - 1) {
                            x++;
                        }
                        break;
                    case 'W':
                        if (x > 0) {
                            x--;
                        }
                        break;
                    case 'N':
                        if (y < n - 1) {
                            y++;
                        }
                        break;
                    case 'S':
                        if (y > 0) {
                            y--;
                        }
                        break;
                    default:
                        break;
                    }
                    diamondsStolen = updateGridDiamonds(grid, diamondsStolen, x, y);
                }
            }

            System.out.println(diamondsStolen + " " + (d - diamondsStolen));

        }

        scanner.close();

    }

    /**
     * Updates the grid diamonds.
     *
     * @param grid the grid
     * @param diamondsStolen the diamonds stolen
     * @param x the x
     * @param y the y
     * @return the int
     */
    private static int updateGridDiamonds(final boolean[][] grid, final int diamondsStolen, final int x, final int y) {

        int currentDiamondsStolen = diamondsStolen;
        if (grid[x][y]) {
            currentDiamondsStolen++;
            grid[x][y] = false;
        }
        return currentDiamondsStolen;
    }
}
