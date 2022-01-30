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
     * <br/>
     * <b>WARN: This is a mutating operation on the list to which the node belongs.</b>
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

    /**
     * Sum lists.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the sum list node
     */
    public static LinkedList<Integer> sumLists(final LinkedList<Integer> list1, final LinkedList<Integer> list2) {

        final Node<Integer> sumNode = sumLists((list1 != null) ? list1.head() : null,
            (list2 != null) ? list2.head() : null,
            0);
        final LinkedList<Integer> sumList = (sumNode != null) ? new LinkedList<Integer>(sumNode) : null;
        return sumList;
    }

    /**
     * Sum lists.
     *
     * @param head1 the head 1
     * @param head2 the head 2
     * @param carry the carry
     * @return the sum list node
     */
    private static Node<Integer> sumLists(final Node<Integer> head1, final Node<Integer> head2, final int carry) {

        if (head1 == null && head2 == null && carry == 0) {
            return null;
        }

        final Node<Integer> sumNode = LinkedList.newNode();
        int sum = carry;

        if (head1 != null) {
            sum += head1.value();
        }
        if (head2 != null) {
            sum += head2.value();
        }

        sumNode.value(sum % 10);

        if (head1 != null || head2 != null) {
            sumNode.next(sumLists(head1 == null ? null : head1.next(),
                head2 == null ? null : head2.next(),
                (sum >= 10) ? 1 : 0));
        }
        return sumNode;
    }

    /**
     * To linked list.
     *
     * @param num the num
     * @return the linked list
     */
    public static LinkedList<Integer> toLinkedList(int num) {

        final LinkedList<Integer> linkedList = new LinkedList<>();

        while (num != 0) {
            linkedList.add(num % 10);
            num /= 10;
        }

        return linkedList;
    }

    /**
     * Divide and merge on partition.
     *
     * @param list the list
     * @param partition the partition
     * @return the linked list
     */
    public static <T extends Comparable<T>> LinkedList<T> divideAndMergeOnPartition(final LinkedList<T> list, final T partition) {

        if (list == null) {
            return null;
        }

        final Node<T> partitionedList = partition(list.head(), partition);
        return (partitionedList != null) ? new LinkedList<T>(partitionedList) : null;
    }

    /**
     * Partition.
     *
     * @param head the head
     * @param partition the partition
     * @return the node
     */
    private static <T extends Comparable<T>> Node<T> partition(final Node<T> head, final T partition) {

        Node<T> part1Start = null;
        Node<T> part1End = null;
        Node<T> part2Start = null;
        Node<T> part2End = null;
        Node<T> current = head;

        while (current != null) {
            final Node<T> next = current.next();
            current.next(null);
            if (current.value().compareTo(partition) < 0) {
                if (part1Start == null) {
                    part1Start = current;
                    part1End = part1Start;
                } else {
                    part1End.next(current);
                    part1End = part1End.next();
                }
            } else {
                if (part2Start == null) {
                    part2Start = current;
                    part2End = part2Start;
                } else {
                    part2End.next(current);
                    part2End = part2End.next();
                }
            }
            current = next;
        }

        if (part1Start == null) {
            return part2Start;
        }
        if (part2Start == null) {
            return part1Start;
        }

        part1End.next(part2Start);

        return part1Start;
    }

}
