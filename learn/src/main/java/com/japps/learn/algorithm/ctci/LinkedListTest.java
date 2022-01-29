/*
 * $Id: LinkedListTest.java 28-Jan-2022 10:25:02 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

import static com.japps.learn.util.LogUtil.printLn;

import com.japps.learn.ds.LinkedList;
import com.japps.learn.ds.LinkedList.Node;
import com.japps.learn.ds.LinkedListOperations;


/**
 * The LinkedListTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class LinkedListTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        testLinkedListBasic();
        testRemoveDuplicates();
        testSubList();
        testRemoveNode();

    }

    /**
     * Test remove node.
     */
    private static void testRemoveNode() {

        final LinkedList<Integer> list11 = new LinkedList<>();
        list11.addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        printLn(list11);
        printLn("Sum: " + LinkedListOperations.sum(list11));

        final Node<Integer> subListNode = list11.subList(5);

        LinkedListOperations.removeNode(subListNode);

        printLn(list11);
        printLn("Sum: " + LinkedListOperations.sum(list11));
    }

    /**
     * Test linked list basic.
     */
    private static void testLinkedListBasic() {

        final LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        printLn(linkedList);
        linkedList.add(4);
        linkedList.remove(Integer.valueOf(2));
        linkedList.add(5);
        linkedList.add(2);
        printLn(linkedList);
        printLn(linkedList.head());
        printLn(linkedList.next(linkedList.head()));
        linkedList.add(8, 3);
        // linkedList.add(10, 19);
        printLn(linkedList);
        linkedList.remove(1);
        linkedList.add(12);
        linkedList.add(100, 0);
        linkedList.add(200, 0);
        printLn(linkedList);
        linkedList.remove(0);
        printLn(linkedList);
        printLn(LinkedListOperations.sum(linkedList));
        printLn(LinkedListOperations.isPresent(linkedList, null));
        printLn(LinkedListOperations.isPresent(linkedList, 5));
        printLn(LinkedListOperations.isPresent(linkedList, 189));
        printLn(linkedList.value(0));
        printLn(linkedList.value(5));
        // printLn(linkedList.value(12));
        printLn(linkedList.size());
        printLn(linkedList.find(5));
        printLn(linkedList.find(190));
        printLn(linkedList);
        linkedList.reverse();
        printLn(linkedList);
        // printLn(LinkedListOperations.zipperLists(linkedList, linkedList));
        final LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);
        linkedList2.add(5);
        linkedList2.add(4);
        printLn(linkedList);
        printLn(linkedList2);
        printLn(LinkedListOperations.zipperLists(linkedList, linkedList2));
        final LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(5);
        list2.add(4);
        final LinkedList<Integer> list2_2 = new LinkedList<>();
        list2_2.add(1);
        list2_2.add(2);
        list2_2.add(3);
        list2_2.add(5);
        list2_2.add(8);
        list2_2.add(9);
        list2_2.add(10);
        list2_2.add(11);
        list2_2.add(15);
        printLn(list2);
        printLn(list2_2);
        printLn(LinkedListOperations.zipperLists(list2, list2_2));
        printLn(LinkedListOperations.zipperLists(list2, null));
        printLn(LinkedListOperations.zipperLists(null, list2));
        printLn(LinkedListOperations.zipperLists(null, null));
        final LinkedList<String> list3 = new LinkedList<String>();
        list3.add("a");
        final LinkedList<String> list4 = new LinkedList<String>();
        list4.add("b");
        printLn(list3);
        printLn(list4);
        printLn(LinkedListOperations.zipperLists(list3, list4));
        final LinkedList<String> list3_2 = new LinkedList<String>();
        list3_2.add("a");
        final LinkedList<String> list5 = new LinkedList<String>();
        printLn(LinkedListOperations.zipperLists(list3_2, list5));
        printLn(LinkedListOperations.zipperLists(list5, list3_2));
        final LinkedList<String> list6 = new LinkedList<String>();
        printLn(LinkedListOperations.zipperLists(list6, list5));
    }

    /**
     * Test remove duplicates.
     */
    private static void testRemoveDuplicates() {

        final LinkedList<String> list7 = new LinkedList<String>();
        list7.addAll("1", "a", "2", "b", "c", "1", "a", "d", "d", "d", "e", "3", "2", "5", "5", "5", "5");
        printLn(list7);
        list7.removeDuplicates();
        printLn(list7);
        final LinkedList<String> list8 = new LinkedList<String>();
        list8.addAll("1", "a", "2", "b", "c", "1", "a", "d", "d", "d", "e", "3", "2", "5", "5", "5", "8");
        printLn(list8);
        list8.removeDuplicates();
        printLn(list8);
        final LinkedList<String> list9 = new LinkedList<String>();
        list9.addAll("1", "a", "2", "b", "c", "1", "a", "d", "9", "d", "d", "e", "3", "2", "5", "5", "5", "8", "9");
        printLn(list9);
        list9.removeDuplicates();
        printLn(list9);
        final LinkedList<String> list10 = new LinkedList<String>();
        list10.addAll("1", "a", "2", "b", "c", "1", "a", "d", "9", "d", "d", "e", "3", "2", "5", "5", "5", "8", "9");
        printLn(list10);
        list10.removeDuplicatesWithoutSet();
        printLn(list10);
    }

    /**
     * Test sub list.
     */
    private static void testSubList() {

        final LinkedList<String> list11 = new LinkedList<String>();
        list11.addAll("1", "a", "2", "b", "c", "1", "a", "d", "9", "d", "d", "e", "3", "2", "5", "5", "5", "8", "9");
        printLn(list11);
        printLn(list11.subList(0));
        printLn(list11.subList(4));
        printLn(list11.subList(7));
        printLn(list11.subList(list11.size() - 1));
        printLn(list11.kthToLastSubList(0));
        printLn(list11.kthToLastSubList(4));
        printLn(list11.kthToLastSubList(7));
        printLn(list11.kthToLastSubList(list11.size() - 1));
    }

}
