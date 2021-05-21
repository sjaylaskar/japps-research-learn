/*
* $Id: BinarySearchTreeSearcher.java 18-Apr-2021 1:39:32 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The BinarySearchTreeSearcher.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BinarySearchTreeSearcher {

    /**
     * Search BST.
     *
     * @param root the root
     * @param val the val
     * @return the binary search tree
     */
    public static BinarySearchTree search(final BinarySearchTree root, final int val) {
        if (root == null || val == root.val) {
            return root;
        }
        if (root.left != null && val == root.left.val) {
            return root.left;
        }
        if (root.right != null && val == root.right.val) {
            return root.right;
        }
        return search((val <= root.val) ? root.left : root.right, val);

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<Integer> nodeValues = Arrays.asList(scanner.nextLine().split(" ")).stream().map(value -> Integer.valueOf(value)).collect(Collectors.toList());

        final int searchValue = scanner.nextInt();

        System.out.println(search(BinarySearchTreeBuilder.build(nodeValues), searchValue));

        scanner.close();
    }
}
