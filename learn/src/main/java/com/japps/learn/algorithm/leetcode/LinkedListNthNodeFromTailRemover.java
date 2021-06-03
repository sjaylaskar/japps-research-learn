/*
 * $Id: LinkedListNthNodeFromTailRemover.java 03-Jun-2021 4:29:40 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The linked list nth node from tail remover.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListNthNodeFromTailRemover {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final ListNode head0 = new ListNode(1);
        head0.next(2).next(3);
        System.out.println(head0);
        System.out.println(removeNthFromEnd(head0, 2));
        System.out.println("==================================");

        final ListNode head1 = new ListNode(1);
        head1.next(2).next(3).next(4).next(5);
        System.out.println(head1);
        System.out.println(removeNthFromEnd(head1, 2));
        System.out.println("==================================");

        final ListNode head2 = new ListNode(1);
        head2.next(2);
        System.out.println(head2);
        System.out.println(removeNthFromEnd(head2, 2));
        System.out.println("==================================");

        final ListNode head3 = new ListNode(1);
        System.out.println(head3);
        System.out.println(removeNthFromEnd(head3, 1));
        System.out.println("==================================");

        final ListNode head4 = new ListNode(1);
        System.out.println(head4);
        System.out.println(removeNthFromEnd(head4, 3));
        System.out.println("==================================");

        System.out.println(removeNthFromEnd(null, 3));
        System.out.println("==================================");

        final ListNode head6 = new ListNode(1);
        head6.next(2).next(3).next(4).next(5);
        System.out.println(head6);
        System.out.println(removeNthFromEnd(head6, 5));
        System.out.println("==================================");
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
     * Removes the nth from end.
     *
     * @param head the head
     * @param n the n
     * @return the list node
     */
    private static ListNode removeNthFromEnd(final ListNode head, final int n) {

        return removeNthNodeByTwoPointersTwoPass(head, n);
    }

    /**
     * Removes the nth node by two pointers two pass.
     *
     * @param head the head
     * @param n the n
     * @return the list node
     */
    private static ListNode removeNthNodeByTwoPointersTwoPass(final ListNode head, final int n) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return (n == 1) ? null : head;
        }

        final ListNode headPrev = new ListNode();
        headPrev.next = head;

        ListNode slow = headPrev;

        ListNode fast = headPrev;

        for (int i = 1; i <= n + 1; ++i) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return headPrev.next;
    }

}
