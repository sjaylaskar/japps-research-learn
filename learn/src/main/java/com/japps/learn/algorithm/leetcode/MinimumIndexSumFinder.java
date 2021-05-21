/*
* $Id: MinimumIndexSumFinder.java 12-May-2021 8:03:46 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.japps.learn.util.ArrayUtil;

/**
 * The minimum index sum finder.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public class MinimumIndexSumFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        final String[] list2 = {"KNN","KFC","Burger King","Tapioca Express","Shogun"};

        ArrayUtil.print(findRestaurant(list1, list2));
    }

    /**
     * Find restaurant.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the string[]
     */
    private static String[] findRestaurant(final String[] list1, final String[] list2) {
        return (list1.length <= list2.length)
               ? determineRestaurants(list1, list2)
               : determineRestaurants(list2, list1);
    }

    /**
     * Determines the restaurants.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the string[]
     */
    private static String[] determineRestaurants(final String[] list1, final String[] list2) {
        return determineByIndexStore(list1, list2);
        //return determineByItemStore(list1, list2);
    }

    /**
     * Determines the by item store.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the string[]
     */
    private static String[] determineByItemStore(final String[] list1, final String[] list2) {
        final HashMap<String, Integer> list2IndexMap = new HashMap<>(list2.length);

        final ArrayList<String> restaurants = new ArrayList<>();

        int min = list1.length + list2.length - 1;

        for (int i = 0; i < list2.length; i++) {
            list2IndexMap.put(list2[i], i);
        }


        for (int i = 0; i < list1.length; i++) {
            final Integer list2Index = list2IndexMap.get(list1[i]);
            if (list2Index != null) {
                final int indexSum = list2Index + i;
                if (min > indexSum) {
                    min = indexSum;
                    restaurants.clear();
                    restaurants.add(list1[i]);
                } else if (min == indexSum) {
                    restaurants.add(list1[i]);
                }
            }
        }

        return restaurants.toArray(new String[restaurants.size()]);
    }

    /**
     * Determines the by index store.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the string[]
     */
    private static String[] determineByIndexStore(final String[] list1, final String[] list2) {
        final HashMap<String, Integer> list2IndexMap = new HashMap<>(list2.length);

        final HashSet<Integer> indicesSet = new HashSet<>();

        int min = list1.length + list2.length - 1;

        for (int i = 0; i < list2.length; i++) {
            list2IndexMap.put(list2[i], i);
        }


        for (int i = 0; i < list1.length; i++) {
            final Integer list2Index = list2IndexMap.get(list1[i]);
            if (list2Index != null) {
                final int indexSum = list2Index + i;
                if (min > indexSum) {
                    min = indexSum;
                    indicesSet.clear();
                    indicesSet.add(i);
                } else if (min == indexSum) {
                    indicesSet.add(i);
                }
            }
        }

        final String[] restaurants = new String[indicesSet.size()];
        int restaurantIndex = -1;
        for (final int index : indicesSet) {
            restaurants[++restaurantIndex] = list1[index];
        }

        return restaurants;
    }
}
