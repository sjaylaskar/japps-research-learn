/*
 * $Id: CubicQuadrupletFinder.java 13-Jan-2022 2:18:14 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.japps.learn.util.AbstractMeasurable;
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

            INSTANCE.startTimer();
            compute1(n);
            INSTANCE.stopTimer();
            INSTANCE.timeElapsed();

            INSTANCE.startTimer();
            compute2(n);
            INSTANCE.stopTimer();
            INSTANCE.timeElapsed();

            INSTANCE.startTimer();
            compute3(n);
            INSTANCE.stopTimer();
            INSTANCE.timeElapsed();
        } finally {
            ScannerProvider.instance().close();
        }
    }

    /**
     * Compute.
     *
     * @param n the n
     */
    private static void compute1(final int n) {

        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            System.out.println(a + ", " + b + ", " + c + ", " + d);
                            ++count;
                        }
                    }
                }
            }
        }
        System.out.println("Number of values: " + count);
    }

    /**
     * Compute 2.
     *
     * @param n the n
     */
    private static void compute2(final int n) {

        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    final int aCube = a * a * a;
                    final int bCube = b * b * b;
                    final int cCube = c * c * c;
                    final int d = (int) (Math.pow((aCube + bCube - cCube), 1 / 3));
                    final int dCube = d * d * d;
                    if (aCube + bCube == cCube + dCube) {
                        System.out.println(a + ", " + b + ", " + c + ", " + d);
                        ++count;
                    }
                }
            }
        }
        System.out.println("Number of values: " + count);
    }

    /**
     * Compute 3.
     *
     * @param n the n
     */
    private static void compute3(final int n) {

        final Map<Integer, List<Pair<Integer, Integer>>> cubicPairs = new HashMap<>();
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                final int aCube = a * a * a;
                final int bCube = b * b * b;
                final int pairCubeSum = aCube + bCube;
                cubicPairs.putIfAbsent(pairCubeSum, new ArrayList<>());
                cubicPairs.get(pairCubeSum).add(new Pair<>(a, b));
            }
        }

        cubicPairs
            .values()
            .stream()
            .filter(value -> value.size() > 1)
            .forEach(value -> {
                value.stream().forEach(pair -> {
                    System.out.print(pair + ", ");
                });
                System.out.println();
            });

        System.out.println("Number of values: "
            + cubicPairs
                .values()
                .stream()
                .filter(value -> value.size() > 1).count());
    }
}
