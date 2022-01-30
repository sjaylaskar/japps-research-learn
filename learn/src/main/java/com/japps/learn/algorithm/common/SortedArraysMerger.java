/*
 * $Id: SortedArraysMerger.java 30-Jan-2022 2:04:54 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.common;

/**
 * The sorted arrays merger.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SortedArraysMerger {

    /**
     * Instantiates a new sorted arrays merger.
     */
    private SortedArraysMerger() {

    }

    /**
     * Merge sorted.
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the int[]
     */
    public static int[] mergeSorted(final int[] arr1, final int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return null;
        }
        if (arr1.length == 0) {
            return arr2;
        }
        if (arr2.length == 0) {
            return arr1;
        }

        final int[] arr3 = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr3[index++] = arr1[i++];
            } else {
                arr3[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr3[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[index++] = arr2[j++];
        }
        return arr3;
    }

}
