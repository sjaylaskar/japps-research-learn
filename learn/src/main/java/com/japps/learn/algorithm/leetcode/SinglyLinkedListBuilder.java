/*
* $Id: SinglyLinkedListBuilder.java 17-Apr-2021 11:38:37 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;


/**
 * The SinglyLinkedListBuilder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class SinglyLinkedListBuilder {

    /**
     * Builds the linked list.
     *
     * @param nodeValues the node values
     * @return the singly linked list
     */
    public static SinglyLinkedList build(final String[] nodeValues) {
        SinglyLinkedList head = null;
        SinglyLinkedList tail = null;

        for (final String nodeValue : nodeValues) {
            final SinglyLinkedList newNode = new SinglyLinkedList(Integer.valueOf(nodeValue));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }
}
