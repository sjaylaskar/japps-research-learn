/*
 * $Id: CanSumComputer.java 24-Jan-2022 1:19:04 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.dp;

import java.util.HashMap;
import java.util.Map;


/**
 * The can sum computer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CanSumComputerTest {

    private static int testCount;

    private final int testNumber;

    private final int target;

    private final int[] numbers;

    /**
     * @param target
     * @param numbers
     */
    private CanSumComputerTest(final int target, final int[] numbers) {

        testNumber = ++testCount;
        this.target = target;
        this.numbers = numbers;
    }

    public static CanSumComputerTest instance(final int target, final int[] numbers) {

        return new CanSumComputerTest(target, numbers);
    }

    public int getTestNumber() {

        return testNumber;
    }

    /**
     * Execute can sum.
     *
     * @param target the target
     * @param numbers the numbers
     * @return true, if successful
     */
    public boolean executeCanSum() {

        return new CanSumComputer().canSum(target, numbers);
    }

    /**
     * Execute can sum memoized.
     *
     * @param target the target
     * @param numbers the numbers
     * @return true, if successful
     */
    public boolean executeCanSumMemoized() {

        return new CanSumComputer().canSumMemoized(target, numbers);
    }

    /**
     * Execute can sum tabularized.
     *
     * @param target the target
     * @param numbers the numbers
     * @return true, if successful
     */
    public boolean executeCanSumTabularized() {

        return new CanSumComputer().canSumTabularized(target, numbers);
    }

    /**
     * The can sum computer.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    static class CanSumComputer {

        /**
         * Can sum.
         *
         * @param target the target
         * @param numbers the numbers
         * @return true, if successful
         */
        boolean canSum(final int target, final int[] numbers) {

            if (target == 0) {
                return true;
            }
            if (target < 0) {
                return false;
            }

            for (final int num : numbers) {
                final int rem = target - num;
                if (canSum(rem, numbers)) {
                    return true;
                }
            }

            return false;
        }

        /** The memo. */
        private final Map<Integer, Boolean> memo = new HashMap<>();

        /**
         * Can sum memoized.
         *
         * @param target the target
         * @param numbers the numbers
         * @return true, if successful
         */
        boolean canSumMemoized(final int target, final int[] numbers) {

            if (memo.containsKey(target)) {
                return memo.get(target);
            }
            if (target == 0) {
                return true;
            }
            if (target < 0) {
                return false;
            }

            for (final int num : numbers) {
                final int rem = target - num;
                if (canSumMemoized(rem, numbers)) {
                    memo.put(target, true);
                    return true;
                }
            }

            memo.put(target, false);
            return false;
        }

        /**
         * Can sum tabularized.
         *
         * @param target the target
         * @param numbers the numbers
         * @return true, if successful
         */
        boolean canSumTabularized(final int target, final int[] numbers) {

            final boolean[] table = new boolean[target + 1];

            table[0] = true;

            for (int i = 0; i <= target; i++) {
                if (table[i]) {
                    for (final int num : numbers) {
                        if (i + num <= target) {
                            table[i + num] = true;
                        }
                        if (table[target]) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }
}
