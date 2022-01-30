/*
* $Id: SortedArraysMergerTest.java 30-Jan-2022 2:05:48 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import com.japps.learn.util.ArrayUtil;

/**
 * The SortedArraysMergerTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SortedArraysMergerTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        testMergeSorted();
    }

    private static void testMergeSorted() {

        final int[] arr1 = new int[] {1, 2, 5, 8, 9, 20, 40};
        final int[] arr2 = new int[] {0, 2, 3, 4, 7, 12, 18, 25, 46};

        ArrayUtil.print(SortedArraysMerger.mergeSorted(arr1, arr2));
    }

}
