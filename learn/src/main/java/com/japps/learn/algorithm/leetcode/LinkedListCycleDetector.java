/*
 * $Id: LinkedListCycleDetector.java 02-Jun-2021 4:05:50 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The linked list cycle detector using <a href="https://en.wikipedia.org/wiki/Cycle_detection"><i>Floyd's Cycle Finding Algorithm</i></a>.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListCycleDetector {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;
        System.out.println(hasCycle(listNode));

    }

    /**
     * Indicates if has cycle.
     *
     * @param head the head
     * @return {@code true}, if successful
     */
    private static boolean hasCycle(final ListNode head) {

        if (head == null
            || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null
            && slow.next != null
            && fast != null
            && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
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
         *
         * @param x the x
         */
        ListNode(final int x) {

            val = x;
        }
    }

}
