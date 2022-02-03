/*
 * $Id: BinaryTreeOperations.java 31-Jan-2022 1:51:06 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import com.japps.learn.ds.BinaryTree.Node;


/**
 * The binary tree operations.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BinaryTreeOperations {

    /**
     * Instantiates a new binary tree operations.
     */
    private BinaryTreeOperations() {

    }

    /**
     * Breadth first values.
     *
     * @param <T> the generic type
     * @param binaryTree the binary tree
     * @return the list of values in the tree in breadth first traversal order
     */
    public static <T> List<T> breadthFirstValues(final BinaryTree<T> binaryTree) {

        if (binaryTree == null) {
            return List.of();
        }

        return breadthFirstValues(binaryTree.root());
    }

    /**
     * Breadth first values.
     *
     * @param <T> the generic type
     * @param root the root
     * @return the list
     */
    private static <T> List<T> breadthFirstValues(final Node<T> root) {

        if (root == null) {
            return List.of();
        }

        final List<T> values = new ArrayList<>();
        final Deque<Node<T>> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            final Node<T> current = deque.poll();
            values.add(current.value());
            if (current.left() != null) {
                deque.add(current.left());
            }
            if (current.right() != null) {
                deque.add(current.right());
            }
        }

        return values;
    }

    /**
     * Depth first values.
     *
     * @param <T> the generic type
     * @param binaryTree the binary tree
     * @return the list
     */
    public static <T> List<T> depthFirstValues(final BinaryTree<T> binaryTree) {

        if (binaryTree == null || binaryTree.root() == null) {
            return List.of();
        }
        return depthFirstValues(binaryTree.root());
    }

    /**
     * Depth first values.
     *
     * @param <T> the generic type
     * @param root the root
     * @return the list
     */
    private static <T> List<T> depthFirstValues(final Node<T> root) {

        if (root == null) {
            return List.of();
        }

        final List<T> values = new ArrayList<>();
        final Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            final Node<T> current = stack.pop();
            values.add(current.value());
            if (current.right() != null) {
                stack.push(current.right());
            }
            if (current.left() != null) {
                stack.push(current.left());
            }
        }
        return values;
    }

    /**
     * Depth first values recurse.
     *
     * @param <T> the generic type
     * @param binaryTree the binary tree
     * @return the list
     */
    public static <T> List<T> depthFirstValuesRecurse(final BinaryTree<T> binaryTree) {

        if (binaryTree == null || binaryTree.root() == null) {
            return List.of();
        }
        return depthFirstValuesRecurse(binaryTree.root());
    }

    /**
     * Depth first values recurse.
     *
     * @param <T> the generic type
     * @param root the root
     * @return the list
     */
    private static <T> List<T> depthFirstValuesRecurse(final Node<T> root) {

        if (root == null) {
            return List.of();
        }

        final List<T> values = new ArrayList<>();

        values.add(root.value());
        values.addAll(depthFirstValuesRecurse(root.left()));
        values.addAll(depthFirstValuesRecurse(root.right()));

        return values;
    }

    /**
     * Checks if is present recurse.
     *
     * @param <T> the generic type
     * @param binaryTree the binary tree
     * @param target the target
     * @return true, if is present recurse
     */
    public static <T> boolean isPresentRecurse(final BinaryTree<T> binaryTree, final T target) {

        return (binaryTree == null) ? false : isPresentRecurse(binaryTree.root(), target);
    }

    /**
     * Checks if is present recurse.
     *
     * @param <T> the generic type
     * @param root the root
     * @param target the target
     * @return true, if is present recurse
     */
    private static <T> boolean isPresentRecurse(final Node<T> root, final T target) {

        if (root == null) {
            return false;
        }
        if (Objects.equals(root.value(), target)) {
            return true;
        }
        return isPresentRecurse(root.left(), target)
            || isPresentRecurse(root.right(), target);
    }

    /**
     * Checks if is present BFS.
     *
     * @param <T> the generic type
     * @param binaryTree the binary tree
     * @param target the target
     * @return true, if is present BFS
     */
    public static <T> boolean isPresentBFS(final BinaryTree<T> binaryTree, final T target) {

        return (binaryTree == null) ? false : isPresentBFS(binaryTree.root(), target);
    }

    /**
     * Checks if is present BFS.
     *
     * @param <T> the generic type
     * @param root the root
     * @param target the target
     * @return true, if is present BFS
     */
    private static <T> boolean isPresentBFS(final Node<T> root, final T target) {

        if (root == null) {
            return false;
        }

        final Deque<Node<T>> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            final Node<T> current = deque.poll();
            if (Objects.equals(current.value(), target)) {
                return true;
            }
            if (current.left() != null) {
                deque.add(current.left());
            }
            if (current.right() != null) {
                deque.add(current.right());
            }
        }

        return false;
    }

    /**
     * Tree sum BFS.
     *
     * @param tree the tree
     * @return the int
     */
    public static int treeSumBFS(final BinaryTree<Integer> tree) {

        return (tree == null) ? 0 : treeSumBFS(tree.root());
    }

    /**
     * Tree sum BFS.
     *
     * @param root the root
     * @return the int
     */
    private static int treeSumBFS(final Node<Integer> root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;
        final Deque<Node<Integer>> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            final Node<Integer> current = deque.poll();
            sum += current.value();
            if (current.left() != null) {
                deque.add(current.left());
            }
            if (current.right() != null) {
                deque.add(current.right());
            }
        }

        return sum;
    }

    /**
     * Tree sum recurse.
     *
     * @param tree the tree
     * @return the int
     */
    public static int treeSumRecurse(final BinaryTree<Integer> tree) {

        return (tree == null) ? 0 : treeSumRecurse(tree.root());
    }

    /**
     * Tree sum recurse.
     *
     * @param root the root
     * @return the int
     */
    private static int treeSumRecurse(final Node<Integer> root) {

        if (root == null) {
            return 0;
        }
        return root.value() + treeSumRecurse(root.left()) + treeSumRecurse(root.right());
    }

}
