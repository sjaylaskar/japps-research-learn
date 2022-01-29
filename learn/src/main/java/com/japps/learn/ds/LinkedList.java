/*
 * $Id: LinkedList.java 28-Jan-2022 10:08:47 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.ds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * The linked list.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 * @param <T> the generic type
 */
public class LinkedList<T> {

    /** The head. */
    private Node<T> head;

    /** The node count. */
    private int size;

    /**
     * The node.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     * @param <T> the generic type
     */
    public static class Node<T> {

        /** The value. */
        private final T value;

        /** The next. */
        private Node<T> next;

        /**
         * Instantiates a new node.
         */
        private Node() {

            this(null);
        }

        /**
         * Instantiates a new node.
         *
         * @param value the value
         */
        private Node(final T value) {

            this.value = value;
        }

        /**
         * Next.
         *
         * @return the node
         */
        public Node<T> next() {

            return this.next;
        }

        /**
         * Next.
         *
         * @param newNext the new next
         */
        public void next(final Node<T> newNext) {

            this.next = newNext;
        }

        /**
         * Value.
         *
         * @return the node
         */
        private T value() {

            return this.value;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            Node<T> current = this;
            final StringBuilder nodeStringBuilder = new StringBuilder();
            while (current != null) {
                nodeStringBuilder.append(current.value);
                if (current.next != null) {
                    nodeStringBuilder.append("->");
                }
                current = current.next;
            }
            return nodeStringBuilder.toString();
        }
    }

    /**
     * Instantiates a new linked list.
     */
    public LinkedList() {

    }

    /**
     * Instantiates a new linked list.
     *
     * @param values the values
     */
    public void addAll(@SuppressWarnings("unchecked")
    final T... values) {

        if (ArrayUtils.isNotEmpty(values)) {
            addAll(Arrays.asList(values));
        }
    }

    /**
     * Adds the all.
     *
     * @param values the values
     */
    public void addAll(final List<T> values) {

        if (CollectionUtils.isNotEmpty(values)) {
            values.forEach(value -> add(value));
        }
    }

    /**
     * Adds the node.
     *
     * @param value the value
     */
    public void add(final T value) {

        checkCapacity();
        final Node<T> node = new Node<T>(value);
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        incrementSize();
    }

    /**
     * Increment size.
     */
    private void incrementSize() {

        ++size;
    }

    /**
     * Adds the node at index.
     *
     * @param value the value
     * @param index the index
     * @return true, if successful
     */
    public boolean add(final T value, final int index) {

        checkCapacity();
        checkBounds(index);
        final Node<T> node = new Node<T>(value);
        if (this.head == null) {
            this.head = node;
            incrementSize();
            return true;
        } else {
            Node<T> prev = new Node<>();
            prev.next = head;
            Node<T> current = head;
            int count = 0;
            while (current != null) {
                if (count++ == index) {
                    prev.next = node;
                    node.next = current;
                    if (index == 0) {
                        this.head = node;
                    }
                    incrementSize();
                    return true;
                }
                prev = prev.next;
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Throw index out of bounds exception.
     *
     * @param index the index
     */
    private void throwIndexOutOfBoundsException(final int index) {

        throw new IndexOutOfBoundsException(errMessage(index));
    }

    /**
     * Err message.
     *
     * @param index the index
     * @return the string
     */
    private String errMessage(final int index) {

        return "Index: " + index + ", Size: " + this.size;
    }

    /**
     * Check capacity.
     */
    private void checkCapacity() {

        if (size >= Integer.MAX_VALUE) {
            throw new OutOfMemoryError("Maximum size attained.");
        }
    }

    /**
     * Removes the node.
     *
     * @param value the value
     * @return true, if successful
     */
    public boolean remove(final T value) {

        if (head == null) {
            return false;
        }
        if (value.equals(head.value)) {
            head = head.next;
            decrementSize();
            return true;
        }
        Node<T> prev = new Node<T>();
        prev.next = head;
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(value, current.value)) {
                prev.next = current.next;
                decrementSize();
                return true;
            }
            prev = prev.next;
            current = current.next;
        }
        return false;
    }

    /**
     * Removes at index.
     *
     * @param index the index
     * @return true, if successful
     */
    public boolean remove(final int index) {

        checkInclusiveBounds(index);
        if (head == null) {
            return false;
        }
        Node<T> prev = new Node<T>();
        prev.next = head;
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count++ == index) {
                prev.next = current.next;
                if (index == 0) {
                    this.head = prev.next;
                }
                decrementSize();
                return true;
            }
            prev = prev.next;
            current = current.next;
        }
        return false;
    }

    /**
     * @param index
     */
    private void checkInclusiveBounds(final int index) {

        if (index < 0 || index > size - 1) {
            throwIndexOutOfBoundsException(index);
        }
    }

    /**
     * Decrement size.
     */
    private void decrementSize() {

        size--;
    }

    /**
     * Checks if the value is present.
     *
     * @param value the value
     * @return true, if successful
     */
    public boolean isPresent(final T value) {

        if (head == null) {
            return false;
        }
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(value, current.value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Finds the.
     *
     * @param targetValue the target value
     * @return the index or -1 if not found.
     */
    public int find(final T targetValue) {

        if (head == null) return -1;

        Node<T> current = head;

        int index = 0;

        while (current != null) {
            if (Objects.equals(current.value(), targetValue)) {
                return index;
            }
            ++index;
            current = current.next;
        }

        return -1;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        if (this.head == null) {
            return StringUtils.EMPTY;
        } else {
            Node<T> current = head;
            final StringBuilder nodeStringBuilder = new StringBuilder();
            while (current != null) {
                nodeStringBuilder.append(current.value);
                if (current.next != null) {
                    nodeStringBuilder.append("->");
                }
                current = current.next;
            }
            return nodeStringBuilder.toString();
        }
    }

    /**
     * Head.
     *
     * @return the node
     */
    public Node<T> head() {

        return this.head;
    }

    /**
     * Next.
     *
     * @param node the node
     * @return the node
     */
    public Node<T> next(final Node<T> node) {

        return (node != null) ? node.next() : null;
    }

    /**
     * Value.
     *
     * @param node the node
     * @return the node
     */
    public T value(final Node<T> node) {

        return (node != null) ? node.value() : null;
    }

    /**
     * Value.
     *
     * @param index the index
     * @return the node
     */
    public T value(final int index) {

        checkInclusiveBounds(index);
        if (head == null) {
            throw new IllegalStateException("List head is null.");
        }
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count++ == index) {
                return current.value;
            }
            current = current.next;
        }

        throw new IllegalStateException("Value not found at valid index: " + index);
    }

    /**
     * Reverse.
     */
    public void reverse() {

        if (this.head == null) {
            return;
        }
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            final Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    /**
     * Next.
     *
     * @param node the node
     * @param newNext the new next
     */
    public void next(final Node<T> node, final Node<T> newNext) {

        node.next(newNext);
    }

    /**
     * Removes the duplicates.
     */
    public void removeDuplicates() {

        final Set<T> visited = new HashSet<>();

        Node<T> prev = new Node<>();
        prev.next = head;
        Node<T> current = head;

        while (current != null) {
            if (!visited.add(current.value())) {
                prev.next = current.next;
                decrementSize();
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
    }

    /**
     * Removes the duplicates without set.
     */
    public void removeDuplicatesWithoutSet() {

        Node<T> current = head;

        while (current != null) {
            Node<T> runner = current;
            while (runner.next != null) {
                if (Objects.equals(runner.next.value, current.value)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /**
     * Sub list.
     *
     * @param index the index
     * @return the node
     */
    public Node<T> subList(final int index) {

        checkInclusiveBounds(index);
        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count++ == index) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    /**
     * Check bounds.
     *
     * @param index the index
     */
    private void checkBounds(final int index) {

        if (index < 0 || index > size) {
            throwIndexOutOfBoundsException(index);
        }

    }

    /**
     * Kth to last sub list.
     *
     * @param k the k
     * @return the node
     */
    public Node<T> kthToLastSubList(final int k) {

        checkInclusiveBounds(k);

        Node<T> current = head;
        Node<T> kThFromCurrent = head;
        int count = -1;

        while (count++ != k) {
            kThFromCurrent = kThFromCurrent.next;
        }

        while (kThFromCurrent != null) {
            current = current.next;
            kThFromCurrent = kThFromCurrent.next;
        }
        return current;
    }

    /**
     * Size.
     *
     * @return the size
     */
    public int size() {

        return size;
    }

}
