/*
 * $Id: LinkedListIntersectionIdentifier.java 03-Jun-2021 2:52:44 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The LinkedListIntersectionIdentifier.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListIntersectionIdentifier {

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
        }
    }

    /**
     * Gets the intersection node.
     *
     * @param headA the head A
     * @param headB the head B
     * @return the intersection node
     */
    public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {

        ListNode listNodeA = headA;
        ListNode listNodeB = headB;

        while (listNodeA != listNodeB) {
            listNodeA = (listNodeA == null) ? headB : listNodeA.next;
            listNodeB = (listNodeB == null) ? headA : listNodeB.next;
        }

        return listNodeB;
    }
}
