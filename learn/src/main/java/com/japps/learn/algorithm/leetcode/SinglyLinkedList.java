/*
 * $Id: SinglyLinkedList.java 17-Apr-2021 11:36:48 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

/**
 * The SinglyLinkedList.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SinglyLinkedList {

    /** The val. */
    int val;

    /** The next. */
    SinglyLinkedList next;

    /**
     * Instantiates a new singly linked list.
     */
    SinglyLinkedList() {

    }

    /**
     * Instantiates a new singly linked list.
     *
     * @param val the val
     */
    SinglyLinkedList(final int val) {

        this.val = val;
    }

    /**
     * Instantiates a new singly linked list.
     *
     * @param val the val
     * @param next the next
     */
    SinglyLinkedList(final int val, final SinglyLinkedList next) {

        this.val = val;
        this.next = next;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        final StringBuilder listString = new StringBuilder();
        SinglyLinkedList node = this;
        while (node != null) {
            listString.append(node.val).append("->");
            node = node.next;
        }

        return listString.append("null").toString();
    }
}
