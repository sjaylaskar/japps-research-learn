/*
* $Id: BinarySearchTreeBuilder.java 18-Apr-2021 1:52:06 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;

import java.util.List;

/**
 * The binary search tree builder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BinarySearchTreeBuilder {

    /**
     * Builds the BST.
     *
     * @param nodeValues the node values
     * @return the binary search tree
     */
    public static BinarySearchTree build(final List<Integer> nodeValues) {

        BinarySearchTree root = null;
        BinarySearchTree curr = null;

        for (final Integer nodeValue : nodeValues) {
            final BinarySearchTree node = new BinarySearchTree(nodeValue);
            if (root == null) {
                root = node;
                curr = node;
            } else if (curr.left == null && node.val <= curr.val) {
                curr.left = node;
                curr = node;
            } else if (curr.right == null && node.val > curr.val) {
                curr.right = node;
                curr = node;
            }
        }

        return root;
    }
}
