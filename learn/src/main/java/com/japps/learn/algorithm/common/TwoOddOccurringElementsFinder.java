/*
* $Id: OddOccuringElementsFinder.java 20-Jul-2022 12:56:58 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The odd occuring elements finder - find two elements occurring
 * odd number of times in an array/list.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TwoOddOccurringElementsFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf).toList();

        System.out.println(findTwoOddTimesOccurringElements(numbers));

        scanner.close();

    }

    /**
     * Finds the two odd times occurring elements.
     *
     * @param numbers the numbers
     * @return the list
     */
    private static List<Integer> findTwoOddTimesOccurringElements(final List<Integer> numbers) {

        int xor = 0;
        for (final int n : numbers) {
            xor ^= n;
        }

        if (xor == 0) {
            return List.of();
        }

        final int setBitPos = findFirstSetBitPosition(xor);

        int num1 = 0, num2 = 0;

        for (final int n : numbers) {
            if ((n & (1 << setBitPos)) > 0) {
                num1 ^= n;
            } else {
                num2 ^= n;
            }
        }

        return Arrays.asList(num1, num2);
    }

    /**
     * Finds the first set bit position.
     *
     * @param xor the xor
     * @return the int
     */
    private static int findFirstSetBitPosition(final int xor) {

        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) > 0) {
                return i;
            }
        }
        return -1;
    }

}
