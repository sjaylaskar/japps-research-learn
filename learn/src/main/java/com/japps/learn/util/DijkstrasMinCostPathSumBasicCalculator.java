/*
 * $Id: DijkstrasMinCostPathSumBasicCalculator.java 07-Feb-2022 5:19:10 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

import java.util.PriorityQueue;

/**
 * The DijkstrasMinCostPathSumBasicCalculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DijkstrasMinCostPathSumBasicCalculator {

    /** The direction vector for row. */
    private static final int dRow[] = {-1, 0, 1, 0};

    /** The direction vector for columns.. */
    private static final int dCol[] = {0, 1, 0, -1};

    /**
     * The cell.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static class Cell {

        /** The x coordinate. */
        private final int x;

        /** The y coordinate. */
        private final int y;

        /** The cost. */
        private final int cost;

        /**
         * Instantiates a new cell.
         *
         * @param x the x
         * @param y the y
         * @param cost the cost
         */
        Cell(final int x, final int y, final int cost) {

            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    /**
     * Indicates if is in safe range.
     *
     * @param x the x
     * @param y the y
     * @param rows the rows
     * @param cols the cols
     * @return {@code true}, if is in safe range
     */
    private static boolean isInSafeRange(final int x, final int y, final int rows, final int cols) {

        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /**
     * Calculates the min cost.
     *
     * @param cost the cost
     * @param rows the rows
     * @param cols the cols
     * @param calcCellXCoord the calc cell X coord
     * @param calcCellYCoord the calc cell Y coord
     * @return the min cost
     */
    public static int calculateMinCost(final int[][] cost, final int rows, final int cols, final int calcCellXCoord,
            final int calcCellYCoord) {

        final int[][] cacheTable = new int[rows][cols];

        final boolean isVisited[][] = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cacheTable[i][j] = Integer.MAX_VALUE;
            }
        }

        final PriorityQueue<Cell> priorityQueue = new PriorityQueue<Cell>((c1, c2) -> Integer.compare(c1.cost, c2.cost));

        cacheTable[0][0] = cost[0][0];
        priorityQueue.add(new Cell(0, 0, cost[0][0]));

        while (!priorityQueue.isEmpty()) {

            final Cell cell = priorityQueue.poll();
            final int x = cell.x;
            final int y = cell.y;
            if (isVisited[x][y]) {
                continue;
            }

            isVisited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                final int movedX = x + dRow[i];
                final int movedY = y + dCol[i];
                if (isInSafeRange(movedX, movedY, rows, cols) && !isVisited[movedX][movedY]) {
                    cacheTable[movedX][movedY] = Math.min(cacheTable[movedX][movedY],
                        cacheTable[x][y] + cost[movedX][movedY]);
                    priorityQueue.add(new Cell(movedX, movedY, cacheTable[movedX][movedY]));
                }
            }
        }

        return cacheTable[calcCellXCoord - 1][calcCellYCoord - 1];
    }
}
