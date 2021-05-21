/*
 * $Id: InternalsTester.java 06-May-2021 3:14:37 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.jdk8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

import com.japps.learn.algorithm.leetcode.DistinctElementFinder;
import com.japps.learn.util.ArrayUtil;


/**
 * The InternalsTester.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class InternalsTester {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        /*
         * final ScannerProvider scannerProvider = ScannerProvider.newInstance();
         * System.out.println(Integer.numberOfLeadingZeros(scannerProvider.scanner().nextInt() - 1));
         * Scanner scan = scannerProvider.scanner();
         * scan.close();
         * scan = null;
         * scannerProvider.scanner().next();
         * scannerProvider.close();
         */
        /*
         * System.out.println(10 % 3);
         * System.out.println(-29 % 3);
         */

        System.out.println(DistinctElementFinder.singleNumber(new int[] {4, 1, 2, 1, 2}));

        System.out.println(DistinctElementFinder.singleNumberByXOR(new int[] {-1, 3, -7, 3, -1, 4, 4}));

        System.out.println(ArrayUtil.xor(new int[] {4, 9, 5}));

    }

}

class TableRow {
    TreeSet<Container> binarySearchTree;

    TableRow() {
        binarySearchTree = new TreeSet<>((c1, c2) -> Integer.compare(c1.key, c2.key));
    }

    void add(final int key) {
        //binarySearchTree.stream().findAny(container -> container.key == key);
    }

    void remove(final int key) {
        binarySearchTree.remove(key);
    }

    public boolean contains(final int key) {
        return binarySearchTree.contains(key);
    }
}

class Container {
    final int key;
    int value;

    Container(final int key, final int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(key);
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Container other = (Container) obj;
        return key == other.key;
    }
}