/*
 * $Id: CubicQuadrupletFinder.java 13-Jan-2022 2:18:14 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

import static com.japps.learn.util.NumberUtil.cube;
import static com.japps.learn.util.NumberUtil.isPairSumEqual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.japps.learn.util.AbstractMeasurable;
import com.japps.learn.util.NumberUtil;
import com.japps.learn.util.Pair;
import com.japps.learn.util.ScannerProvider;


/**
 * The cubic quadruplet finder.
 * Find in range (1, n), the quadruplets to the equation:
 * <i>a^3 + b^3 = c^3 + d^3</i>.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CubicQuadrupletFinder extends AbstractMeasurable {

    /** The Constant INSTANCE. */
    private static final CubicQuadrupletFinder INSTANCE = instance();

    /**
     * Instance.
     *
     * @return the cubic quadruplet finder
     */
    private static CubicQuadrupletFinder instance() {

        return new CubicQuadrupletFinder();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        try {
            final int n = ScannerProvider.instance().scanner().nextInt();


              //startTime();
              //compute1(n);
              //stopAndPrintTime();


            /*
             * INSTANCE.startTimer();
             * compute2(n);
             * INSTANCE.stopTimer();
             * INSTANCE.timeElapsed();
             */

            startTime();
            compute3(n);
            stopAndPrintTime();

        } finally {
            ScannerProvider.instance().close();
        }
    }

    /**
     *
     */
    private static void startTime() {

        INSTANCE.startTimer();
    }

    /**
     *
     */
    private static void stopAndPrintTime() {

        INSTANCE.stopTimer();
          INSTANCE.timeElapsed();
    }

    /**
     * Compute.
     *
     * @param n the n
     */
    private static void compute1(final int n) {

        final Map<Long, List<Pair<Integer, Integer>>> resultPairsMap = new HashMap<>();
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        final long aCube = cube(a);
                        final long bCube = cube(b);
                        final long cCube = cube(c);
                        final long dCube = cube(d);
                        if (isPairSumEqual(aCube, bCube, cCube, dCube)) {
                            final long result = NumberUtil.sum(aCube, bCube);
                            resultPairsMap.putIfAbsent(result, new ArrayList<>());
                            resultPairsMap.get(result).add(new Pair<Integer, Integer>(a, b));
                            resultPairsMap.get(result).add(new Pair<Integer, Integer>(c, d));
                        }
                    }
                }
            }
        }

        printResult(resultPairsMap);

    }

    /**
     * Prints the result.
     *
     * @param resultPairsMap the result pairs map
     */
    private static void printResult(final Map<Long, List<Pair<Integer, Integer>>> resultPairsMap) {

        final long count = printAndCountResult(resultPairsMap);

        System.out.println("Number of values: " + count);

        System.out.println("======================================================================");
    }

    /**
     * Compute 2.
     *
     * @param n the n
     */
    private static void compute2(final int n) {

        /*
         * int count = 0;
         * for (int a = 1; a <= n; a++) {
         * for (int b = 1; b <= n; b++) {
         * for (int c = 1; c <= n; c++) {
         * final long aCube = cube(a);
         * final long bCube = cube(b);
         * final long cCube = cube(c);
         * final long dCubeByEqn = aCube + bCube - cCube;
         * final long dByEqn = (long) Math.pow(dCubeByEqn, 1 / 3);
         * final long dCubeByPow = cube(dByEqn);
         * if (isPairSumEqual(aCube, bCube, cCube, dCubeByPow)) {
         * System.out.println(a + ", " + b + ", " + c + ", " + dByEqn);
         * ++count;
         * }
         * }
         * }
         * }
         * System.out.println("Number of values: " + count);
         */
    }

    /**
     * Compute 3.
     *
     * @param n the n
     */
    private static void compute3(final int n) {

        final Map<Long, List<Pair<Integer, Integer>>> resultPairsMap = new HashMap<>();
        for (int c = 1; c <= n; c++) {
            for (int d = 1; d <= n; d++) {
                final long result = NumberUtil.cube(c) + NumberUtil.cube(d);
                resultPairsMap.putIfAbsent(result, new ArrayList<>());
                resultPairsMap.get(result).add(new Pair<Integer, Integer>(c, d));
            }
        }

        printResult(resultPairsMap);
    }

    /**
     * Prints the and count result.
     *
     * @param resultPairsMap the result pairs map
     * @return the long
     */
    private static long printAndCountResult(final Map<Long, List<Pair<Integer, Integer>>> resultPairsMap) {

        long count = 0;
        for (final Entry<Long, List<Pair<Integer, Integer>>> entry : sortedResultMap(resultPairsMap).entrySet()) {
            for (final Pair<Integer, Integer> pair1 : entry.getValue()) {
                for (final Pair<Integer, Integer> pair2 : entry.getValue()) {
                    ++count;
                    System.out.println(entry.getKey() + " : " + pair1 + ", " + pair2);
                }
            }
        }
        return count;
    }

    /**
     * Sorted result map.
     *
     * @param resultPairsMap the result pairs map
     * @return the tree map
     */
    private static TreeMap<Long, List<Pair<Integer, Integer>>> sortedResultMap(
            final Map<Long, List<Pair<Integer, Integer>>> resultPairsMap) {

        return new TreeMap<Long, List<Pair<Integer, Integer>>>(resultPairsMap);
    }
}
