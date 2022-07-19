/*
* $Id: StringPermutationGenerator.java 10-Jul-2022 12:10:32 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.g4g.medium;

import java.util.Arrays;

/**
 * The StringPermutationGenerator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DistinctNumbersArrayPermutationGenerator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        printPermutations(new int[] {0, 1, 2, 3}, 0, 3);

        printPermutations(new int[] {0, 1, 2}, 0, 2);
    }

    private static void printPermutations(int[] nums, final int leftIndex, final int rightIndex) {
        if (leftIndex == rightIndex) {
            System.out.print("{");
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println("}");
        } else {
            for (int index = leftIndex; index <= rightIndex; index++) {
                nums = swap(nums, leftIndex, index);
                printPermutations(nums, leftIndex + 1, rightIndex);
                nums = swap(nums, leftIndex, index);
            }
        }
    }

    private static int[] swap(final int[] nums, final int index1, final int index2) {
        final int num = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = num;
        return nums;
    }
}
