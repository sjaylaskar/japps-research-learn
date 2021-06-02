/*
* $Id: CustomDoublyLinkedList.java 02-Jun-2021 1:02:30 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.leetcode;


/**
 * The CustomDoublyLinkedList.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CustomDoublyLinkedList {

    /**
     * The node.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private class Node {

        /** The val. */
        int val;

        /** The prev. */
        Node prev;

        /** The next. */
        Node next;

        /**
         * Instantiates a new node.
         */
        Node() {

        }

        /**
         * Instantiates a new node.
         *
         * @param val the val
         */
        Node(final int val) {
            this.val = val;
        }
    }

    /** The head. */
    private Node head;

    /** The tail. */
    private Node tail;

    /** The size. */
    private int size;

    /** Initialize your data structure here. */
    public CustomDoublyLinkedList() {

    }

    /**
     *  Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     *
     * @param index the index
     * @return the int
     */
    public int get(final int index) {
        if (size == 0
            || index < 0
            || index >= size) {
            return -1;
        }

        if (index == 0) {
            return head.val;
        }
        if (index == size - 1) {
            return tail.val;
        }

        int count = 0;
        Node node = head;
        while (count++ < index) {
            node = node.next;
        }
        return node.val;
    }

    /**
     *  Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     *
     * @param val the val
     */
    public void addAtHead(final int val) {
        if (head == null
            || size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            final Node current = new Node(val);
            current.next = head;
            head.prev = current;
            head = current;
        }
        incrementSize();
    }

    /**
     *  Append a node of value val to the last element of the linked list.
     *
     * @param val the val
     */
    public void addAtTail(final int val) {
        if (tail == null
            || size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            final Node current = new Node(val);
            tail.next = current;
            current.prev = tail;
            tail = current;
        }
        incrementSize();
    }

    /**
     *  Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     *
     * @param index the index
     * @param val the val
     */
    public void addAtIndex(final int index, final int val) {
        if (index >= 0
            && index <= size) {
            if (size == 0 || index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else if (index == size - 1) {
                final Node current = new Node(val);
                current.next = tail;
                tail.prev.next = current;
                current.prev = tail.prev;
                tail.prev = current;
                incrementSize();
            } else {
                int count = 0;
                Node node = head;
                while (count++ < index) {
                    node = node.next;
                }
                final Node current = new Node(val);
                current.next = node;
                node.prev.next = current;
                current.prev = node.prev;
                node.prev = current;
                incrementSize();
            }
        }
    }

    /**
     *  Delete the index-th node in the linked list, if the index is valid.
     *
     * @param index the index
     */
    public void deleteAtIndex(final int index) {
        if (index >= 0
            && index < size) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
            } else if (index == 0) {
                head = head.next;
                head.next.prev = null;
            } else if (index == size - 1) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                int count = 0;
                Node node = head;
                while (count++ < index) {
                  node = node.next;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            decrementSize();
        }
    }

    /**
     * Increment size.
     */
    private void incrementSize() {

        ++size;
    }

    /**
     * Decrement size.
     */
    private void decrementSize() {

        --size;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        final StringBuilder listString = new StringBuilder();
        Node node = head;
        while (node != null) {
            listString.append(node.val).append("->");
            node = node.next;
        }

        return listString.append("null").toString();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        /*["MyLinkedList",
         * "addAtHead",
         * "deleteAtIndex",
         * "addAtHead",
         * "addAtHead",
         * "addAtHead",
         * "addAtHead",
         * "addAtHead",
         * "addAtTail",
         * "get",
         * "deleteAtIndex",
         * "deleteAtIndex"]
                [[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]] */

        CustomDoublyLinkedList doublyLinkedList = new CustomDoublyLinkedList();

        doublyLinkedList.addAtHead(2);
        doublyLinkedList.deleteAtIndex(1);
        doublyLinkedList.addAtHead(2);
        doublyLinkedList.addAtHead(7);
        doublyLinkedList.addAtHead(3);
        doublyLinkedList.addAtHead(2);
        doublyLinkedList.addAtHead(5);
        doublyLinkedList.addAtTail(5);
        System.out.println(doublyLinkedList.get(5));
        doublyLinkedList.deleteAtIndex(6);
        doublyLinkedList.deleteAtIndex(4);

        /*["MyLinkedList",
         * "addAtHead",
         * "addAtIndex",
         * "addAtTail",
         * "addAtHead",
         * "addAtIndex",
         * "addAtTail",
         * "addAtTail",
         * "addAtIndex",
         * "deleteAtIndex",
         * "deleteAtIndex",
         * "addAtTail"]
                [[],[0],[1,4],[8],[5],[4,3],[0],[5],[6,3],[7],[5],[4]]*/
        doublyLinkedList = new CustomDoublyLinkedList();
        doublyLinkedList.addAtHead(0);
        doublyLinkedList.addAtIndex(1, 4);
        doublyLinkedList.addAtTail(8);
        doublyLinkedList.addAtHead(5);
        doublyLinkedList.addAtIndex(4, 3);
        doublyLinkedList.addAtTail(0);
        doublyLinkedList.addAtTail(5);
        doublyLinkedList.addAtIndex(6, 3);
        doublyLinkedList.deleteAtIndex(7);
        doublyLinkedList.deleteAtIndex(5);
        doublyLinkedList.addAtTail(4);
        System.out.println(doublyLinkedList);

    }

}
