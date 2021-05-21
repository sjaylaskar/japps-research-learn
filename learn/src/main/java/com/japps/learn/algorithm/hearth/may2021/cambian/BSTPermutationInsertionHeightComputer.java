/*
* $Id: BSTPermutationInsertionHeightComputer.java 18-May-2021 12:34:13 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.may2021.cambian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * The BST permutation insertion height computer.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public class BSTPermutationInsertionHeightComputer {

    /** The max. */
    int MAX = 1000000000;

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            final int N = Integer.parseInt(br.readLine().trim());
            final String[] arr_A = br.readLine().split(" ");
            final int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            final int out_ = solve(N, A);
            System.out.println(out_);

         }

         wr.close();
         br.close();
    }

    /**
     * Solve.
     *
     * @param n the n
     * @param arr the arr
     * @return the int
     */
    private static int solve(final int n, final int[] arr) {
        final BinarySearchTree binarySearchTree = new BinarySearchTree();

        for (final int num : arr) {
            binarySearchTree.insert(num);
        }

        return binarySearchTree.height();

    }

    /**
     * The binary search tree.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static class BinarySearchTree {

        /**
         * The node.
         *
         * @author Subhajoy Laskar
         * @version 1.0 $ Revision: $
         */
        private class Node {

           /** The data. */
           private final int data;

           /** The right. */
           private Node left, right;

           /**
            * Instantiates a new node.
            *
            * @param data the data
            */
           private Node(final int data) {
              this.data = data;
              left = right = null;
           }
        }

        /** The root. */
        private Node root;

        /**
         * Insert.
         *
         * @param data the data
         */
        private void insert(final int data) {
            root = insert(root, data);
        }

        /**
         * Insert.
         *
         * @param node the root
         * @param data the data
         * @return the node
         */
        private Node insert(final Node node, final int data) {
            if (node == null) {
                root = new Node(data);
                return root;
            }

            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            }

            return node;
        }

        /**
         * Height.
         *
         * @param node the node
         * @return the height of the tree or 0 if the tree is either empty or has only root.
         */
        private int height(final Node node) {
            if (node == null || (node.left == null && node.right == null)) {
                return 0;
            }

            final int leftHeight = height(node.left);
            final int rightHeight = height(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        /**
         * Height.
         *
         * @return the int
         */
        private int height() {
            return height(root);
        }
    }
}