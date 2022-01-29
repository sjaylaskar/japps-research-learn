/*
 * $Id: LinkedListOperations.java 29-Jan-2022 2:29:41 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.ds;

import com.japps.learn.ds.LinkedList.Node;


/**
 * The LinkedListOperations.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListOperations {

    /**
     * Sum.
     *
     * @param list the list
     * @return the sum
     */
    public static int sum(final LinkedList<Integer> list) {

        if (list.head() == null) return 0;

        Node<Integer> current = list.head();
        int sum = 0;
        while (current != null) {
            sum += list.value(current);
            current = list.next(current);
        }
        return sum;
    }

    /**
     * Checks if is present.
     *
     * @param <T> the generic type
     * @param list the list
     * @param value the value
     * @return true, if is present
     */
    public static <T> boolean isPresent(final LinkedList<T> list, final T value) {

        return list.isPresent(value);
    }

    /**
     * Zipper lists.
     * <br/>
     * <b>WARNING: This operation mutates the lists. </b>
     *
     * @param <T> the generic type
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the linked list
     */
    public static <T> LinkedList<T> zipperLists(final LinkedList<T> list1, final LinkedList<T> list2) {

        if ((list1 == null || list1.head() == null)
            && (list2 == null || list2.head() == null)) {
            return null;
        }

        if (list1 == null || list1.head() == null) {
            return list2;
        }

        if (list2 == null || list2.head() == null) {
            return list1;
        }

        Node<T> tail = list1.head();
        Node<T> current1 = list1.head().next();
        Node<T> current2 = list2.head();
        int count = 0;

        while (current1 != null && current2 != null) {
            if (count % 2 == 0) {
                tail.next(current2);
                current2 = current2.next();
            } else {
                tail.next(current1);
                current1 = current1.next();
            }
            tail = tail.next();
            count++;
        }
        if (current1 != null) {
            tail.next(current1);
        }
        if (current2 != null) {
            tail.next(current2);
        }
        return list1;
    }

    /**
     * Removes the node.
     * <br/><b>WARN: This is a mutating operation on the list to which the node belongs.</b>
     *
     * @param <T> the generic type
     * @param node the node
     * @return true, if successful
     */
    public static <T> boolean removeNode(Node<T> node) {

        if (node == null) {
            return false;
        }
        if (node.next() == null) {
            node = null;
        }
        final Node<T> next = node.next();
        node.value(next.value());
        node.next(next.next());
        return true;
    }

}
