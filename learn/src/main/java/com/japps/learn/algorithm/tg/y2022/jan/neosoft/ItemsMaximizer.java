/*
 * $Id: ItemsMaximizer.java 05-Jan-2022 10:48:18 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.jan.neosoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.japps.learn.util.ScannerProvider;


/**
 * The ItemsMaximizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ItemsMaximizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        try {
            final Scanner scanner = ScannerProvider.instance().scanner();

            final int n = scanner.nextInt();
            final long d = scanner.nextLong();
            final List<Long> prices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                prices.add(scanner.nextLong());

            }
            Collections.sort(prices);
            long sum = 0;
            long count = -1;
            final long[] sums = new long[n];
            for (int i = 0; i < n; i++) {
                sum += prices.get(i);
                sums[i] = sum;
                if (sum > d) {
                    count = i;
                    break;
                }
            }
            if (count == -1) {
                final long count1 = d / sum;
                final long rem = d % sum;
                if (rem == 0) {
                    count = n;
                } else {
                    count = (n * count1) + binarySearchClosestFinder(sums, rem);
                }
            }
            System.out.println(count);
        } finally {
            ScannerProvider.instance().close();
        }

    }

    /**
     * Binary search closest finder.
     *
     * @param arr the arr
     * @param target the target
     * @return the int
     */
    private static final int binarySearchClosestFinder(final long[] arr, final long target) {

        final int n = arr.length;

        if (target <= arr[0]) {
            return 1;
        }
        if (target >= arr[n - 1]) {
            return n;
        }

        int low = 0, high = n, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid + 1;
            }

            if (target < arr[mid]) {
                if (mid > 0 && target > arr[mid - 1]) {
                    return getClosest(arr, mid - 1, mid, target);
                }
                high = mid;
            } else {
                if (mid < n - 1 && target < arr[mid + 1]) {
                    return getClosest(arr, mid, mid + 1, target);
                }
                low = mid + 1;
            }
        }

        return mid;
    }

    /**
     * Gets the closest.
     *
     * @param arr the arr
     * @param pos1 the pos 1
     * @param pos2 the pos 2
     * @param target the target
     * @return the closest
     */
    private static int getClosest(final long[] arr, final int pos1, final int pos2, final long target) {

        return (target - arr[pos1] >= arr[pos2] - target) ? pos2 : pos1;
    }

}
