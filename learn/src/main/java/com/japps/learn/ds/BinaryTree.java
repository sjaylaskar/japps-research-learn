/*
 * $Id: BinaryTree.java 31-Jan-2022 1:35:29 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.ds;

/**
 * The binary tree.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 * @param <T> the generic type
 */
public class BinaryTree<T> {

    /** The root. */
    private Node<T> root;

    /**
     * Instantiates a new binary tree.
     */
    public BinaryTree() {

    }

    /**
     * Instantiates a new binary tree.
     *
     * @param root the root
     */
    public BinaryTree(final Node<T> root) {

        this.root = root;
    }

    /**
     * Root.
     *
     * @return the node
     */
    public Node<T> root() {

        return root;
    }

    public void root(final Node<T> root) {
        this.root = root;
    }

    /**
     * The node.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     * @param <T> the generic type
     */
    public static class Node<T> {

        /** The value. */
        private T value;

        /** The left. */
        private Node<T> left;

        /** The right. */
        private Node<T> right;

        /**
         * Instantiates a new node.
         */
        public Node() {

        }

        /**
         * Instantiates a new node.
         *
         * @param value the value
         */
        public Node(final T value) {

            this.value = value;
        }

        /**
         * Left.
         *
         * @param node the node
         */
        public void left(final Node<T> node) {

            this.left = node;
        }

        /**
         * Left.
         *
         * @param value the value
         */
        public void left(final T value) {

            this.left = new Node<>(value);
        }

        /**
         * Right.
         *
         * @param node the node
         */
        public void right(final Node<T> node) {

            this.right = node;
        }

        /**
         * Right.
         *
         * @param value the value
         */
        public void right(final T value) {

            this.right = new Node<>(value);
        }

        /**
         * Value.
         *
         * @param value the value
         */
        public void value(final T value) {

            this.value = value;
        }

        /**
         * Left.
         *
         * @return the node
         */
        public Node<T> left() {

            return left;
        }

        /**
         * Right.
         *
         * @return the node
         */
        public Node<T> right() {

            return right;
        }

        /**
         * Value.
         *
         * @return the t
         */
        public T value() {

            return value;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return String.valueOf(value);
        }
    }
}
