/*
* $Id: SinglyLinkedList.java 05-Jun-2021 3:29:07 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

/**
 * The SinglyLinkedList.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SinglyLinkedList {

    /** The list node. */
    private ListNode listNode;


    /**
     * Instantiates a new singly linked list.
     */
    public SinglyLinkedList() {

    }

    /**
     * List node.
     *
     * @param val the val
     * @return the list node
     */
    public ListNode listNode(final int val) {
        listNode = new ListNode(val);
        return listNode;
    }

    /**
     * Next.
     *
     * @param val the val
     * @return the list node
     */
    public ListNode next(final int val) {
        return listNode.next(val);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        return listNode.toString();
    }

    /**
     * The list node.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private class ListNode {

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
}
