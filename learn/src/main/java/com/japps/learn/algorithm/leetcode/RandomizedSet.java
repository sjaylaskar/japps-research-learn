/*
 * $Id: RandomizedSet.java 26-May-2021 1:33:51 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The RandomizedSet.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class RandomizedSet {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final int[] randomCountsFor1And2 = new int[2];
        for (int i = 0; i < 100; i++) {
            System.out.println("====================================================================");
            testRandomizedSet(randomCountsFor1And2);
            System.out.println("====================================================================");
        }
        System.out.println("Probabilities: (1, 2): (" + (randomCountsFor1And2[0] / 100.0) + ", " + (randomCountsFor1And2[1] / 100.0) + ")");
    }

    /**
     * Test randomized set.
     *
     * @param randomCountsFor1And2 the random counts for 1 and 2
     */
    private static void testRandomizedSet(final int[] randomCountsFor1And2) {

        final RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        final int randomPick = randomizedSet.getRandom();
        randomCountsFor1And2[(randomPick == 1) ? 0 : 1]++;
        System.out.println(randomPick); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }

    /** The num index map. */
    private final Map<Integer, Integer> numIndexMap;

    /** The num list. */
    private final List<Integer> numList;

    /** Initialize your data structure here. */
    public RandomizedSet() {

        numIndexMap = new HashMap<>();
        numList = new ArrayList<>();
    }

    /**
     *  Inserts a value to the set. Returns true if the set did not already contain the specified element.
     *
     * @param val the val
     * @return {@code true}, if successful
     */
    public boolean insert(final int val) {

        if (numIndexMap == null || numIndexMap.containsKey(val)) {
            return false;
        }
        numList.add(val);
        numIndexMap.put(val, numList.size() - 1);
        return true;
    }

    /**
     *  Removes a value from the set. Returns true if the set contained the specified element.
     *
     * @param val the val
     * @return {@code true}, if successful
     */
    public boolean remove(final int val) {

        if (numIndexMap == null || !numIndexMap.containsKey(val)) {
            return false;
        }
        final int index = numIndexMap.remove(val);
        if (index == numList.size() - 1) {
            numList.remove(index);
            return true;
        }
        final int lastNum = numList.get(numList.size() - 1);
        numList.set(index, lastNum);
        numList.remove(numList.size() - 1);
        numIndexMap.put(lastNum, index);
        return true;
    }

    /**
     *  Get a random element from the set.
     *
     * @return the random
     */
    public int getRandom() {

        return numList.get(new Random().nextInt(numList.size()));
    }
}
