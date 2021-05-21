/*
* $Id: HappyNumberChecker.java 08-May-2021 4:23:03 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.HashSet;
import java.util.stream.IntStream;

import com.japps.learn.util.ScannerProvider;

/**
 * The happy number checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class HappyNumberChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final ScannerProvider scannerProvider = ScannerProvider.newInstance();

        final int n = scannerProvider.scanner().nextInt();

        scannerProvider.close();

        System.out.println(isHappy(n));

        System.out.println(isHappy(Integer.MAX_VALUE));

        System.out.println("============================================================================");
        //IntStream.range(1, 10001).forEach(num -> System.out.println("isHappy(" + num + ") : " + isHappy(num)));
    }

    /**
     * Indicates if is happy.
     *
     * @param n the n
     * @return {@code true}, if is happy
     */
    public static boolean isHappy(final int n) {
        //return isHappyNumberByHashSet(n);

        //return isHappyByTwoPointers(n);

        return isHappyByLogic(n);
    }

    /**
     * Indicates if is happy number by hash set.
     *
     * @param n the n
     * @return {@code true}, if is happy number by hash set
     */
    private static boolean isHappyNumberByHashSet(final int n) {

        final HashSet<Integer> digitSquareSumSet = new HashSet<>();

        int num = n;

        int digitSquareSum = -1;

        while (digitSquareSum != 1) {
            digitSquareSum = digitSquareSum(num);

            if (!digitSquareSumSet.add(digitSquareSum)) {
                return false;
            }

            num = digitSquareSum;
        }

        return true;
    }

    /**
     * Indicates if is happy by two pointers.
     *
     * @param n the n
     * @return {@code true}, if is happy by two pointers
     */
    private static boolean isHappyByTwoPointers(final int n) {
        int slowDigitSquareSum = n, fastDigitSquareSum = n;

        do {
            slowDigitSquareSum = digitSquareSum(slowDigitSquareSum);

            fastDigitSquareSum = digitSquareSum(digitSquareSum(fastDigitSquareSum));

        } while (slowDigitSquareSum != fastDigitSquareSum);

        if (slowDigitSquareSum == 1) {
            return true;
        }

        return false;
    }

    /**
     * Indicates if is happy by logic.
     *
     * @param n the n
     * @return {@code true}, if is happy by logic
     */
    private static boolean isHappyByLogic(final int n) {
        if (isOneOrSeven(n)) {
            return true;
        }

        int sum = n, num = n;

        while (sum > 9) {
            sum = 0;

            sum = digitSquareSum(num);

            if (isOneOrSeven(sum)) {
                return true;
            }
            num = sum;
        }

        return isOneOrSeven(sum);
    }

    /**
     * Indicates if is one or seven.
     *
     * @param num the num
     * @return {@code true}, if is one or seven
     */
    private static boolean isOneOrSeven(final int num) {

        return num == 1 || num == 7;
    }

    /**
     * Digit square sum.
     *
     * @param n the n
     * @return the digit square sum
     */
    private static int digitSquareSum(final int n) {

        int digitSquareSum = 0;

        int num = n;

        while (num != 0) {
            final int digit = num % 10;
            digitSquareSum += (digit * digit);
            num /= 10;
        }

        return digitSquareSum;
    }
}
