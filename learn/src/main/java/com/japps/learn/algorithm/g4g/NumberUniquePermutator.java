/*
 * $Id: NumberUniquePermutator.java 23-Apr-2021 1:50:30 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.g4g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * The NumberUniquePermutator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class NumberUniquePermutator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final ArrayList<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(x -> Integer.valueOf(x)).collect(Collectors
            .toCollection(ArrayList::new));

        final Set<ArrayList<Integer>> numsSet = new HashSet<>();

        final ArrayList<ArrayList<Integer>> numsList = new ArrayList<>();
        permute(nums, 0, nums.size() - 1, numsSet, numsList);

        System.out.println(numsSet);

        /*
         * final char[] numsCharArr = new char[nums.size()];
         * for (int i = 0; i < nums.size(); i++) {
         * numsCharArr[i] = String.valueOf(nums.get(i)).charAt(0);
         * }
         * final HashSet<String> numsStrSet = new HashSet<String>();
         * StringUniquePermutator.permute(numsCharArr, 0, nums.size() - 1, numsStrSet);
         * numsStrSet.stream().map(numStr -> Arrays.stream(numStr.split("")).map(s ->
         * Integer.valueOf(s)).collect(Collectors.toCollection(ArrayList::new)))
         * .collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
         */

        // final Set<String> numsSet = new HashSet<>();
        // permute(nums, 0, nums.size() - 1, numsSet);

        // numsSet.stream().map(x ->
        // Arrays.asList(x.split(""))).collect(Collectors.toList()).stream().forEach(System.out::println);;

        scanner.close();

    }

    /**
     * Permute.
     *
     * @param nums the str
     * @param left the left
     * @param right the right
     * @param numsSet the nums set
     * @param numsList the nums list
     */
    private static void permute(final ArrayList<Integer> nums, final int left, final int right, final Set<ArrayList<Integer>> numsSet, final ArrayList<ArrayList<Integer>> numsList) {

        // TODO
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
