/*
* $Id: DPTest.java 24-Jan-2022 1:25:28 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.dp;

import java.util.Arrays;
import java.util.List;

import com.japps.learn.util.Loggable;

/**
 * The DPTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DPTest implements Loggable {

    private static final DPTest DP_TEST = new DPTest();

    private DPTest() {

    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        DP_TEST.testexecuteCanSum();

    }

    public void testexecuteCanSum() {
        final List<CanSumComputerTest> tests = Arrays.asList(new CanSumComputerTest[]
                {
                 CanSumComputerTest.instance(7, new int[] {1, 3, 5, 4, 7}),
                 CanSumComputerTest.instance(7, new int[] {2, 4}),
                 CanSumComputerTest.instance(500, new int[] {25, 3, 5, 90}),
                 CanSumComputerTest.instance(51, new int[] {10, 7}),
                 CanSumComputerTest.instance(0, new int[] {9, 18, 29}),
                 CanSumComputerTest.instance(300, new int[] {7, 14}),
                 CanSumComputerTest.instance(10000, new int[] {7, 14}),
                 CanSumComputerTest.instance(1000000, new int[] {7, 14})
                });

        println("canSum()");
        tests.stream().filter(test -> test.getTestNumber() <= 5).forEach(test -> println(test.getTestNumber() + ": " + test.executeCanSum()));

        println("canSumMemoized()");
        tests.stream().filter(test -> test.getTestNumber() <= 7).forEach(test -> println(test.getTestNumber() + ": " + test.executeCanSumMemoized()));

        println("canSumTabularized()");
        tests.forEach(test -> println(test.getTestNumber() + ": " + test.executeCanSumTabularized()));
    }
}
