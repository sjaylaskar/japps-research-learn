/*
 * $Id: BinaryTree.java 31-Jan-2022 1:35:29 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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

    /**
     * Root.
     *
     * @param root the root
     */
    public void root(final Node<T> root) {
        this.root = root;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final String treeString = toTreeString();
        return treeString;
    }

    /**
     * To tree string.
     *
     * @return the string
     */
    private String toTreeString() {
        if (root == null) {
            return StringUtils.EMPTY;
        }

        final List<Node<T>> nodeList = new ArrayList<>();
        final Deque<Node<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final Node<T> current = queue.poll();
            nodeList.add(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return nodeList.toString();
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
         * @return the node
         */
        public Node<T> left(final Node<T> node) {

            this.left = node;
            return this.left;
        }

        /**
         * Left.
         *
         * @param value the value
         * @return the node
         */
        public Node<T> left(final T value) {

            this.left = new Node<>(value);
            return this.left;
        }

        /**
         * Right.
         *
         * @param node the node
         * @return the node
         */
        public Node<T> right(final Node<T> node) {

            this.right = node;
            return this.right;
        }

        /**
         * Right.
         *
         * @param value the value
         * @return the node
         */
        public Node<T> right(final T value) {

            this.right = new Node<>(value);
            return this.right;
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
