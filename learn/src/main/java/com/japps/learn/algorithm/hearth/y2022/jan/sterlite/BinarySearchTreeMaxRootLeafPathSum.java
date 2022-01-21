/*
 * $Id: BinarySearchTreeMaxRootLeafPathSum.java 20-Jan-2022 2:59:47 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jan.sterlite;

import java.util.Scanner;


/**
 * The BinarySearchTreeMaxRootLeafPathSum.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class BinarySearchTreeMaxRootLeafPathSum {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(final String args[]) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            final int n = scanner.nextInt();

            final BinarySearchTree bst = new BinarySearchTree();

            for (int j = 1; j <= n; j++) {
                bst.insert(scanner.nextLong());

                System.out.print(BinarySearchTree.maxRootToLeafSum(bst.root) + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    /**
     * The binary search tree.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static final class BinarySearchTree {

        /**
         * The node.
         *
         * @author Subhajoy Laskar
         * @version 1.0
         */
        private static final class Node {

            /** The key. */
            private final long key;

            /** The right. */
            private Node left, right;

            /**
             * Instantiates a new node.
             *
             * @param key the key
             */
            Node(final long key) {

                this.key = key;

                left = right = null;
            }
        }

        /** The root. */
        private Node root;

        /**
         * Instantiates a new binary search tree.
         */
        BinarySearchTree() {

            root = null;
        }

        /**
         * Insert.
         *
         * @param key the key
         */
        void insert(final long key) {

            root = insert(root, key);
        }

        /**
         * Insert.
         *
         * @param root the root
         * @param key the key
         * @return the node
         */
        Node insert(Node root, final long key) {

            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key) {
                root.left = insert(root.left, key);
            } else if (key > root.key) {
                root.right = insert(root.right, key);
            }

            return root;
        }


        /**
         * Gets the max root to leaf sum.
         *
         * @param root the root
         * @return the max root to leaf sum
         */
        static long maxRootToLeafSum(final Node root)
        {
            if (root == null) {
                return Long.MIN_VALUE;
            }

            if (root.left == null && root.right == null) {
                return root.key;
            }

            final long left = maxRootToLeafSum(root.left);

            final long right = maxRootToLeafSum(root.right);

            return (Math.max(left,  right)) + root.key;
        }
    }

}
