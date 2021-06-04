/*
* $$ Id: LinkedListReverser.java 17-Apr-2021 11:37:17 pm SubhajoyLaskar $$
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/

package com.japps.learn.algorithm.leetcode;

import java.util.Scanner;


/**
 * The linked list reverser.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListReverser {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String[] nodeValues = scanner.nextLine().split("->");

        scanner.close();

        //System.out.println(build(nodeValues));

        final SinglyLinkedList singlyLinkedList = SinglyLinkedListBuilder.build(nodeValues);
        System.out.println(singlyLinkedList);
        System.out.println(reverse(singlyLinkedList));

        System.out.println("====================================");

        final ListNode head = new ListNode(1);
        head.next(1).next(2).next(4).next(3).next(5);
        System.out.println(head);
        System.out.println(reverse(head));
        System.out.println("====================================");
        final ListNode head2 = new ListNode(4);
        head2.next(5);
        System.out.println(head2);
        System.out.println(reverse(head2));
    }

    /**
     * Reverse.
     *
     * @param head the head
     * @return the list node
     */
    private static SinglyLinkedList reverse(final SinglyLinkedList head) {

        SinglyLinkedList prev = null;
        SinglyLinkedList curr = head;

        while (curr != null) {
            final SinglyLinkedList tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        return prev;
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
     * Reverse.
     *
     * @param head the head
     * @return the list node
     */
    private static ListNode reverse(final ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            final ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

}