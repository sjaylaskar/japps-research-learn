/*
 * $Id: LinkedListCycleIdentifier.java 03-Jun-2021 12:31:22 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The linked list cycle identifier.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListCycleIdentifier {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub

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
            next = null;
        }
    }

    /**
     * Detect cycle.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode detectCycle(final ListNode head) {

        return detectCycleBySlowFast(head);
        // return detectCycleBySlowFastIntersect(head);
    }

    /**
     * Detect cycle by slow fast.
     *
     * @param head the head
     * @return the list node
     */
    private static ListNode detectCycleBySlowFast(final ListNode head) {

        if (head == null
            || head.next == null) {
            return null;
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
                break;
            }
        }

        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }

        return null;
    }

    /**
     * Detect cycle by slow fast intersect.
     *
     * @param head the head
     * @return the list node
     */
    private static ListNode detectCycleBySlowFastIntersect(final ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow != null && slow == fast) {
                ListNode node1 = head;
                ListNode node2 = slow;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }
}
