/*
* $Id: NumberPermutator.java 23-Apr-2021 1:31:15 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The number permutator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NumberPermutator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(x -> Integer.valueOf(x)).collect(Collectors.toList());

        permute(nums, 0, nums.size() - 1);

        scanner.close();

    }

    /**
     * Permute.
     *
     * @param nums the str
     * @param left the left
     * @param right the right
     */
    private static void permute(final List<Integer> nums, final int left, final int right) {

        if (left == right) {
            System.out.println(nums);
        } else {
            for (int i = left; i <= right; i++) {
                 swap(nums, left, i);
                 permute(nums, left + 1, right);
                 swap(nums, left, i);
            }
        }
    }

    /**
     * Swap.
     *
     * @param nums the str
     * @param left the left
     * @param right the right
     */
    private static void swap(final List<Integer> nums, final int left, final int right) {
        final int temp = nums.get(left);
        nums.set(left, nums.get(right));
        nums.set(right, temp);
    }

}
