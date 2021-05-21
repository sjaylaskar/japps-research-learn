/*
 * $Id: MaxPrimeDifferenceInRangeCalculator.java 27-Mar-2021 2:10:55 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.cg2021.round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


/**
 * The max prime difference in range calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MaxPrimeDifferenceInRangeCalculator {

    /** The max range. */
    private static final int MAX_RANGE = 1000005;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int testCaseCount = scanner.nextInt();

        final List<Pair<Integer, Integer>> ranges = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            ranges.add(new Pair<Integer, Integer>(scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();

        ranges.forEach(pair -> System.out.println(maxPrimeDifference(pair)));

    }

    /**
     * Max prime difference.
     *
     * @param range the range
     * @return the max prime difference
     */
    private static int maxPrimeDifference(final Pair<Integer, Integer> range) {

        final int[] primeLessThanOrEqualTo = new int[MAX_RANGE];

        final int[] primeGreaterThanOrEqualTo = new int[MAX_RANGE];

        calculateSieveOfEratosthenes(primeLessThanOrEqualTo, primeGreaterThanOrEqualTo);

        return calculateMaxDifference(primeLessThanOrEqualTo, primeGreaterThanOrEqualTo, range);
    }

    /**
     * Sieve of Eratosthenes.
     *
     * @param primeLessThanOrEqualTo the prefix
     * @param primeGreaterThanOrEqualTo the suffix
     */
    private static void calculateSieveOfEratosthenes(final int primeLessThanOrEqualTo[], final int primeGreaterThanOrEqualTo[]) {

        final boolean isPrime[] = new boolean[MAX_RANGE];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < MAX_RANGE; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX_RANGE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        primeLessThanOrEqualTo[1] = 1;
        primeGreaterThanOrEqualTo[MAX_RANGE - 1] = (int) 1e9 + 7;

        for (int i = 2; i < MAX_RANGE; i++) {
            primeLessThanOrEqualTo[i] = (isPrime[i]) ? i : primeLessThanOrEqualTo[i - 1];
        }

        for (int i = MAX_RANGE - 2; i > 1; i--) {
            primeGreaterThanOrEqualTo[i] = (isPrime[i]) ? i : primeGreaterThanOrEqualTo[i + 1];
        }
    }

    /**
     * Calculate max difference.
     *
     * @param primeLessThanOrEqualTo the prime less than or equal to
     * @param primeGreaterThanOrEqualTo the prime greater than or equal to
     * @param range the range
     * @return the max difference
     */
    private static int calculateMaxDifference(final int primeLessThanOrEqualTo[], final int primeGreaterThanOrEqualTo[],
            final Pair<Integer, Integer> range) {

        if (primeLessThanOrEqualTo[range.second()] < range.first() || primeGreaterThanOrEqualTo[range.first()] > range.second()) {
            return -1;
        } else {
            return primeLessThanOrEqualTo[range.second()] - primeGreaterThanOrEqualTo[range.first()];
        }
    }
}

/**
 * The pair.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 * @param <U> the generic type
 * @param <V> the value type
 */
final class Pair<U, V> {

    /** The first. */
    private final U first;

    /** The second. */
    private final V second;

    /**
     * Instantiates a new pair.
     *
     * @param first the first
     * @param second the second
     */
    public Pair(final U first, final V second) {

        this.first = first;
        this.second = second;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {

        return Objects.hash(first, second);
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return {@code true}, if successful
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        final Pair other = (Pair) obj;
        return Objects.equals(first, other.first) && Objects.equals(second, other.second);
    }

    /**
     * The first.
     *
     * @return the first
     */
    public U first() {

        return first;
    }

    /**
     * The second.
     *
     * @return the second
     */
    public V second() {

        return second;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        return "(" + first + ", " + second + ")";
    }

}
