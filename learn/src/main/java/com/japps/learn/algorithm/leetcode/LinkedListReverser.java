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

        System.out.println(reverse(SinglyLinkedListBuilder.build(nodeValues)));

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

}