/*
 * $Id: LinkedListOddEvenizer.java 04-Jun-2021 2:09:31 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The linked list odd evenizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListOddEvenizer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final ListNode head = new ListNode(1);
        head.next(2).next(6).next(3).next(4).next(5).next(6);
        System.out.println(head);
        System.out.println(oddEvenList(head));
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
     * Odd even list.
     *
     * @param head the head
     * @return the list node
     */
    private static ListNode oddEvenList(final ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        final ListNode evenPointer = even;

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenPointer;

        return head;
    }

}
