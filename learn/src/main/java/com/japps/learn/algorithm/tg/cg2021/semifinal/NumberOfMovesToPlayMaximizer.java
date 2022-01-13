/*
 * $Id: NumberOfMovesToPlayMaximizer.java 02-Jul-2021 12:18:46 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.cg2021.semifinal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;


/**
 * The number of moves to play maximizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NumberOfMovesToPlayMaximizer {

    /** The space. */
    private static final String SPACE = " ";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        scanner.nextLine();
        final String[] packetLengthStrings = scanner.nextLine().split(SPACE);
        long maxMoves = 0;
        for (int i = 0; i < n; i++) {
            maxMoves += calculateMaxMovesToPlay(Long.parseLong(packetLengthStrings[i]));
        }
        System.out.println(maxMoves);
        scanner.close();

    }

    /**
     * Calculate max moves to play.
     *
     * @param packetLength the packet length
     * @return the max moves to play
     */
    private static long calculateMaxMovesToPlay(final long packetLength) {

        // return computerMaxMovesBySieve(packetLength);
        return computeMaxMovesByFactorization(packetLength);
    }

    /**
     * Compute max moves by factorization.
     *
     * @param packetLength the packet length
     * @return the max moves
     */
    private static long computeMaxMovesByFactorization(final long packetLength) {

        if (packetLength == 1) {
            return 1;
        }

        final LinkedHashMap<Long, Long> primeFactors = factorize(packetLength);

        if (primeFactors.size() == 1) {
            return packetLength + 1;
        } else {
            long processedNumber = packetLength;
            long moves = processedNumber;
            for (final Entry<Long, Long> primeFactor : primeFactors.entrySet()) {
                for (int i = 1; i <= primeFactor.getValue(); i++) {
                    processedNumber = processedNumber / primeFactor.getKey();
                    moves += processedNumber;
                }
            }
            return moves;
        }
    }

    /**
     * Factorize.
     *
     * @param n the n
     * @return the prime factors
     */
    private static LinkedHashMap<Long, Long> factorize(long n) {
        final LinkedHashMap<Long, Long> primeFactors = new LinkedHashMap<>();

        long count = 0;

        while (!(n % 2 > 0)) {
            n >>= 1;
            count++;
        }

        if (count > 0) {
            primeFactors.put(Long.valueOf(2), count);
        }

        for (long i = 3; i <= (long) Math.sqrt(n); i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            if (count > 0) {
                primeFactors.put(i, count);
            }
        }

        if (n > 2) {
            primeFactors.put(n, Long.valueOf(1));
        }

        return primeFactors;
    }

    /**
     * Computer max moves by sieve.
     *
     * @param packetLength the packet length
     * @return the max moves
     */
    private static long computerMaxMovesBySieve(final long packetLength) {

        if (packetLength == 1) {
            return 1;
        }
        if (packetLength <= MAX_SIZE) {
            final int number = (int) packetLength;
            if (IS_PRIME.get(number)) {
                return number + 1;
            } else {
                final long moves = number;
                return computeNonPrimeMaxMoves(number, moves);
            }
        } else {
            for (int i = 0; i < Math.sqrt(packetLength); i++) {
                if (packetLength % PRIME.get(i) == 0) {
                    final int firstSPF = PRIME.get(i);
                    final int number = (int) (packetLength / firstSPF);
                    final long moves = packetLength + number;
                    return computeNonPrimeMaxMoves(number, moves);
                }
            }
            return packetLength + 1;
        }
    }

    /**
     * Compute non prime max moves.
     *
     * @param number the number
     * @param moves the moves
     * @return the long
     */
    private static long computeNonPrimeMaxMoves(final int number, long moves) {

        int processedNumber = number;
        while (true) {
            final int spf = SMALLEST_PRIME_FACTOR.get(processedNumber);
            if (processedNumber == spf) {
                moves += 1;
                break;
            }
            processedNumber = processedNumber / spf;
            moves += processedNumber;
        }
        return moves;
    }

    /** The max size. */
    private static final int MAX_SIZE = 1000000;

    /** The is prime. */
    private static final List<Boolean> IS_PRIME = new ArrayList<>();

    /** The prime. */
    private static final List<Integer> PRIME = new ArrayList<>();

    /** The smallest prime factor. */
    private static final List<Integer> SMALLEST_PRIME_FACTOR = new ArrayList<>();

    static {
        /*
         * for (int i = 0; i < MAX_SIZE; i++) {
         * IS_PRIME.add(true);
         * SMALLEST_PRIME_FACTOR.add(2);
         * }
         * computeSieveOfEratosthenes(MAX_SIZE);
         */
    }

    /**
     * Compute sieve of Eratosthenes.
     *
     * @param number the number
     */
    private static void computeSieveOfEratosthenes(final int number) {

        IS_PRIME.set(0, false);
        IS_PRIME.set(1, false);

        for (int i = 2; i < number; i++) {
            if (IS_PRIME.get(i)) {
                PRIME.add(i);

                SMALLEST_PRIME_FACTOR.set(i, i);
            }

            for (int j = 0; j < PRIME.size()
                && i * PRIME.get(j) < number
                && PRIME.get(j) <= SMALLEST_PRIME_FACTOR.get(i);
                    j++) {
                IS_PRIME.set(i * PRIME.get(j), false);

                SMALLEST_PRIME_FACTOR.set(i * PRIME.get(j), PRIME.get(j));
            }
        }
    }
}
