/*
* $Id: HashSetTest.java 30-May-2021 4:23:30 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The HashSetTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class HashSetTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Set<List<Integer>> listSet = new HashSet<>();

        final List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        final List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 1, 4));
        final List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        final List<Integer> list4 = new ArrayList<>(Arrays.asList(4, 3, 2, 1));

        listSet.add(list1);
        listSet.add(list2);
        listSet.add(list3);
        listSet.add(list4);

        final List<List<Integer>> listOfList1 = new ArrayList<>();
        listOfList1.add(new ArrayList<>(Arrays.asList(1)));
         System.out.println(listSet.size());

        System.out.println(listSet);
    }

}
