/*
 * $Id: CoinChangeCounter.java 18-Apr-2021 6:08:17 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * The coin change counter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CoinChangeCounter {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int coinSum = scanner.nextInt();

        scanner.nextLine();

        final List<Integer> coins = Arrays.asList(scanner.nextLine().split(" ")).stream().map(coin -> Integer.valueOf(coin))
            .collect(Collectors.toList());

        System.out.println(count(coins, coinSum));

        scanner.close();

    }

    /**
     * Count.
     *
     * @param coins the coins
     * @param coinSum the coin sum
     * @return the count of coin change
     */
    public static int count(final List<Integer> coins, final int coinSum) {
        final int[] memo = new int[coinSum + 1];

        memo[0] = 1;

        coins.forEach(coin -> count(coinSum, memo, coin));

        return memo[coinSum];
    }

    /**
     * Count.
     *
     * @param coinSum the coin sum
     * @param memo the memo
     * @param coin the coin
     */
    private static void count(final int coinSum, final int[] memo, final int coin) {

        for (int coinNumber = coin; coinNumber <= coinSum; coinNumber++) {
            memo[coinNumber] += memo[coinNumber - coin];
        }
    }
}