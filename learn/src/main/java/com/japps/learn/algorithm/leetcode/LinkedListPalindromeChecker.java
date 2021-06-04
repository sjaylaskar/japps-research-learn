/*
 * $Id: LinkedListPalindromeChecker.java 05-Jun-2021 3:26:29 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * The LinkedListPalindromeChecker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListPalindromeChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final ListNode head = new ListNode(1);
        head.next(2).next(2).next(1);
        System.out.println(head);
        System.out.println(isPalindrome(head));
        System.out.println(head);
        System.out.println("=======================================");

        final ListNode head2 = new ListNode(1);
        head2.next(2);
        System.out.println(head2);
        System.out.println(isPalindrome(head2));
        System.out.println(head2);
        System.out.println("=======================================");

        final ListNode head3 = null;
        System.out.println(head3);
        System.out.println(isPalindrome(head3));
        System.out.println(head3);
        System.out.println("=======================================");

        final ListNode head4 = new ListNode(1);
        head4.next(2).next(3).next(4).next(5);
        System.out.println(head4);
        System.out.println(isPalindrome(head4));
        System.out.println(head4);
        System.out.println("=======================================");

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
     * Indicates if is palindrome.
     *
     * @param head the head
     * @return {@code true}, if is palindrome
     */
    private static boolean isPalindrome(final ListNode head) {

        // return isPalindromeByLeftRightBarrierDivisionReverseCheck(head);
        // return isPalindromeByRightHalfReverse(head);
        return isPalindromByArray(head);
    }

    /**
     * Indicates if is palindrom by array.
     *
     * @param head the head
     * @return {@code true}, if is palindrom by array
     */
    private static boolean isPalindromByArray(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        final List<Integer> nodeValues = new ArrayList<>();

        while (head != null) {
            nodeValues.add(head.val);
            head = head.next;
        }

        for (int i = 0; i <= ((nodeValues.size() % 2 == 0) ? (nodeValues.size() - 1) / 2 : nodeValues.size() / 2); ++i) {
            if (nodeValues.get(i) != nodeValues.get(nodeValues.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Indicates if is palindrome by right half reverse.
     *
     * @param head the head
     * @return {@code true}, if is palindrome by right half reverse
     */
    private static boolean isPalindromeByRightHalfReverse(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode right = head;

        int size = 0;

        while (right != null) {
            right = right.next;
            ++size;
        }

        size /= 2;

        right = head;

        for (int i = 1; i <= size; ++i) {
            right = right.next;
        }

        right = reverse(right);

        for (int i = 1; i <= size; i++) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }

        return true;
    }

    /**
     * Indicates if is palindrome by left right barrier division reverse check.
     *
     * @param head the head
     * @return {@code true}, if is palindrome by left right barrier division reverse check
     */
    private static boolean isPalindromeByLeftRightBarrierDivisionReverseCheck(final ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode curr = head;

        int size = 1;
        while ((curr = curr.next) != null) {
            ++size;
        }

        ListNode left = head;

        ListNode right = head;

        final int barrier = (size % 2 == 0) ? (size / 2) : (size + 1) / 2;
        for (int i = 1; i <= barrier; ++i) {
            right = right.next;
        }

        right = reverse(right);
        boolean isPalindrome = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                isPalindrome = false;
                break;
            }

            left = left.next;
            right = right.next;
        }

        return isPalindrome;

    }

    /**
     * Reverse.
     *
     * @param head the head
     * @return the list node
     */
    private static ListNode reverse(final ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

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
