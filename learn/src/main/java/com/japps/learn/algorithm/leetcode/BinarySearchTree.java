/*
 * $Id: BinarySearchTree.java 18-Apr-2021 1:38:51 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The binary search tree.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BinarySearchTree {

    /** The val. */
    int val;

    /** The left. */
    BinarySearchTree left;

    /** The right. */
    BinarySearchTree right;

    /**
     * Instantiates a new binary search tree.
     */
    BinarySearchTree() {

    }

    /**
     * Instantiates a new binary search tree.
     *
     * @param val the val
     */
    BinarySearchTree(final int val) {

        this.val = val;
    }

    /**
     * Instantiates a new binary search tree.
     *
     * @param val the val
     * @param left the left
     * @param right the right
     */
    BinarySearchTree(final int val, final BinarySearchTree left, final BinarySearchTree right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Insert.
     *
     * @param val the val
     * @return the binary search tree
     */
    public BinarySearchTree insert(final int val) {

        // @TODO

        return null;
    }

    /**
     * Delete.
     *
     * @param val the val
     * @return the binary search tree
     */
    public BinarySearchTree delete(final int val) {

        // @TODO

        return null;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        // TODO Auto-generated method stub
        return super.toString();
    }

    /**
     * Traverse.
     *
     * @param root the root
     * @param nodeValue the node value
     * @return the string
     */
    public String traverse(final BinarySearchTree root, final String nodeValue) {
        return traverse(root, root.left, root.right, nodeValue);
    }

    /**
     * Traverse.
     *
     * @param root the root
     * @param left the left
     * @param right the right
     * @param nodeValue the node value
     * @return the string
     */
    private String traverse(final BinarySearchTree root, final BinarySearchTree left, final BinarySearchTree right, final String nodeValue) {

        return "";
    }
}
