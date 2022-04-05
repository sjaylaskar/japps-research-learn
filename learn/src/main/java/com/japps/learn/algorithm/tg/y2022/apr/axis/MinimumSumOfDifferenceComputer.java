/*
* $Id: MinimumSumOfDifferenceComputer.java 06-Apr-2022 1:23:55 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.apr.axis;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The minimum sum of difference computer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MinimumSumOfDifferenceComputer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
             final int n = scanner.nextInt();

             scanner.nextLine();

             final List<Integer> nums = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
             Collections.sort(nums, Comparator.reverseOrder());
             System.out.println(IntStream.range(0, n - 1).map(index -> Math.abs(nums.get(index) - nums.get(index + 1))).sum());
        }

        scanner.close();

    }

}
