/*
 * $Id: LinkedListGivenValueNodeRemover.java 04-Jun-2021 1:10:11 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The linked list given value node remover.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListGivenValueNodeRemover {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        ListNode head = new ListNode(1);
        head.next(2).next(6).next(3).next(4).next(5).next(6);
        System.out.println(head);
        System.out.println(removeElements(head, 6));

        System.out.println("======================================");

        head = new ListNode(7);
        head.next(7).next(7).next(7);
        System.out.println(head);
        System.out.println(removeElements(head, 7));

    }

    /**
     * The list node.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static class ListNode {

        /** The val. */
        int val;

        /** The next. */
        ListNode next;

        /**
         * Instantiates a new list node.
         */
        ListNode() {

        }

        /**
         * Instantiates a new list node.
         *
         * @param x the x
         */
        ListNode(final int x) {

            val = x;
        }

        /**
         * Next.
         *
         * @param x the x
         * @return the list node
         */
        ListNode next(final int x) {

            next = new ListNode(x);
            return next;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            final StringBuilder listString = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                listString.append(node.val).append("->");
                node = node.next;
            }

            return listString.append("null").toString();
        }
    }

    /**
     * Removes the elements.
     *
     * @param head the head
     * @param val the val
     * @return the list node
     */
    private static ListNode removeElements(final ListNode head, final int val) {

        //return removeElementsByPrevCurr(head, val);
        return removeElementsByCurr(head, val);
    }

    /**
     * Removes the elements by prev curr.
     *
     * @param head the head
     * @param val the val
     * @return the list node
     */
    private static ListNode removeElementsByPrevCurr(final ListNode head, final int val) {

        if (head == null
            || (head.next == null && head.val == val)) {
            return null;
        }

        final ListNode headPrev = new ListNode();
        headPrev.next = head;

        ListNode prev = headPrev;
        ListNode curr = head;

        while (curr != null) {

            if (curr.val == val) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }

        return headPrev.next;
    }

    /**
     * Removes the elements by curr.
     *
     * @param head the head
     * @param val the val
     * @return the list node
     */
    private static ListNode removeElementsByCurr(ListNode head, final int val) {

        if (head == null
            || (head.next == null && head.val == val)) {
            return null;
        }

        ListNode curr = new ListNode(-1);
        curr.next = head;
        head = curr;

        while (curr.next != null) {

            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head = head.next;
    }
}
