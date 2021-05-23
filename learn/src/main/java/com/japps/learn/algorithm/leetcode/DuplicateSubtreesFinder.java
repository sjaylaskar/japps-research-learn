/*
 * $Id: DuplicateSubtreesFinder.java 24-May-2021 4:37:24 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The duplicate subtrees finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class DuplicateSubtreesFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        System.out.println(findDuplicateSubtrees(root));
    }

    /** The duplicate subtree roots. */
    private static List<TreeNode> duplicateSubtreeRoots;

    /** The subtree count map. */
    private static Map<String, Integer> subtreeCountMap;

    /**
     * Find duplicate subtrees.
     *
     * @param root the root
     * @return the list
     */
    private static List<TreeNode> findDuplicateSubtrees(final TreeNode root) {
        duplicateSubtreeRoots = new ArrayList<>();
        subtreeCountMap = new HashMap<>();

        traverseInorder(root);

        return duplicateSubtreeRoots;
    }

    /**
     * Traverse inorder.
     *
     * @param node the node
     * @return the string
     */
    private static String traverseInorder(final TreeNode node) {

        if (node == null) {
            return "";
        }

        final String treeNodeStr = new StringBuilder("(")
            .append(traverseInorder(node.left))
            .append(node.val)
            .append(traverseInorder(node.right))
            .append(")").toString();

        final Integer subtreeCount = subtreeCountMap.get(treeNodeStr);
        if (subtreeCount != null && subtreeCount == 1) {
            duplicateSubtreeRoots.add(node);
        }

        subtreeCountMap.put(treeNodeStr, (subtreeCount != null) ? subtreeCount + 1 : 1);

        return treeNodeStr;
    }

    /**
     * The tree node.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static class TreeNode {

        /** The val. */
        int val;

        /** The left. */
        TreeNode left;

        /** The right. */
        TreeNode right;

        /**
         * Instantiates a new tree node.
         */
        TreeNode() {

        }

        /**
         * Instantiates a new tree node.
         *
         * @param val the val
         */
        TreeNode(final int val) {

            this.val = val;
        }

        /**
         * Instantiates a new tree node.
         *
         * @param val the val
         * @param left the left
         * @param right the right
         */
        TreeNode(final int val, final TreeNode left, final TreeNode right) {

            this.val = val;
            this.left = left;
            this.right = right;
        }

        /**
         * Traverse preorder.
         *
         * @return the string
         */
        public String traversePreorder() {
            return traversePreorder(this);
        }

        /**
         * Traverse preorder.
         *
         * @param node the node
         * @return the string
         */
        public String traversePreorder(final TreeNode node) {
            if (node == null) {
                return "";
            }

            return new StringBuilder("(")
                   .append(node.val)
                   .append(traversePreorder(node.left))
                   .append(traversePreorder(node.right))
                   .append(")")
                   .toString();
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return traversePreorder();
        }
    }
}
