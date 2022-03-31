/*
* $Id: MarketItemsMaximizer.java 18-May-2021 5:29:50 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2021.may.nike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The market items maximizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MarketItemsMaximizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        final long d = scanner.nextLong();

        final long[] prices = new long[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextLong();
        }

        System.out.println(maximizeBuy(prices, d));

        scanner.close();
    }

    /**
     * Maximize buy.
     *
     * @param prices the prices
     * @param d the d
     * @return the long
     */
    private static long maximizeBuy(final long[] prices, final long d) {

        Arrays.sort(prices);

        final long[] cummulativePrices = new long[prices.length];
        cummulativePrices[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            cummulativePrices[i] = prices[i] + cummulativePrices[i - 1];

            if (cummulativePrices[i] > d) {
                return i;
            }
        }

        final long sumOfPrices = cummulativePrices[cummulativePrices.length - 1];
        final long itemsCount = prices.length * (d / sumOfPrices);
        final long remainingAmount = (d % sumOfPrices);

        final long remainingItemsCount = floorBinarySearch(cummulativePrices, remainingAmount, 0, prices.length - 1) + 1;

        return itemsCount + remainingItemsCount;
    }

    /**
     * Floor binary search.
     *
     * @param arr the arr
     * @param key the key
     * @param low the low
     * @param high the high
     * @return the long
     */
    private static long floorBinarySearch(final long[] arr, final long key,
                                          final int low, final int high) {

        if (low > high) {
            return -1;
        }

        if (key >= arr[high]) {
            return high;
        }

        final int mid = (low + high) / 2;

        if (key == arr[mid]) {
            return mid;
        }

        if (mid > 0 && arr[mid - 1] <= key && key < arr[mid]) {
            return mid - 1;
        }

        if (key < arr[mid]) {
            return floorBinarySearch(arr, key, low, mid - 1);
        }

        return floorBinarySearch(arr, key, mid + 1, high);

    }

}
