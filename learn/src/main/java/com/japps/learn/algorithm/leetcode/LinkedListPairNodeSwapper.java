/*
 * $Id: LinkedListPairNodeSwapper.java 12-Apr-2021 4:22:33 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.Scanner;


/**
 * The linked list pair node swapper.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListPairNodeSwapper {

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

        System.out.println(swapPairs(SinglyLinkedListBuilder.build(nodeValues)));

    }

    /**
     * Swap pairs.
     *
     * @param head the head
     * @return the list node
     */
    private static SinglyLinkedList swapPairs(final SinglyLinkedList head) {

        if (head != null && head.next != null) {
            final int temp = head.val;
            head.val = head.next.val;
            head.next.val = temp;
            if (head.next.next != null) {
                head.next.next = swapPairs(head.next.next);
            }
        }

        return head;
    }

}