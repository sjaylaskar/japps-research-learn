/*
 * $$ Id: ThreadStringCollector.java 26-Mar-2021 2:19:44 am SubhajoyLaskar $$
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.virtusa.mar2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The thread string collector.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public class ThreadStringCollector {

    /** The scanner. */
    private static final Scanner SCANNER = new Scanner(System.in);

    /** The strings collection. */
    private static final StringsCollection STRINGS_COLLECTION = new StringsCollection();

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final int threadsCount = Integer.parseInt(SCANNER.nextLine());

        final List<String> stringsCollection = getStrings(threadsCount);

        int nonNullStrings = 0;
        for (final String string : stringsCollection) {
            if (string != null) {
                nonNullStrings++;
            }
        }
        System.out.println(nonNullStrings);
        STRINGS_COLLECTION.clear();
    }

    /**
     * Gets the strings.
     *
     * @param threadsCount the threads count
     * @return the strings
     */
    private static List<String> getStrings(final int threadsCount) {

        final Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            final int stringsCount = Integer.parseInt(SCANNER.nextLine());
            threads[i] = new Thread(new StringsCollectionRunnable(STRINGS_COLLECTION, stringsCount, String.valueOf(i + 1)));
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (final InterruptedException ex) {
                System.err.println(ex);
            }
        }

        final List<String> stringsCollection = STRINGS_COLLECTION.getStringsCollection();
        System.out.println(stringsCollection.size());

        return stringsCollection;
    }

    /**
     * Gets the strings.
     *
     * @param threadsThreshold the threads threshold
     * @param strings the strings
     * @return the strings
     */
    public static List<String> getStrings(final int threadsThreshold, final List<String> strings) {

        // final Thread[] threads = new Thread[threadsCount];
        //if (stringsCount < threadsCount) {
           // final int diff = threadsCount - stringsCount;
            for (int i = 0; i < threadsThreshold; i++) {
                strings.add("Thread" + i);
            }
        //}
        /*
         * for (int i = 0; i < threadsCount; i++) {
         * threads[i] = new Thread(new StringsCollectionRunnable(STRINGS_COLLECTION, stringsCount, strings.get(i)));
         * threads[i].start();
         * }
         * for (int i = 0; i < threadsCount; i++) {
         * try {
         * threads[i].join();
         * } catch (final InterruptedException ex) {
         * System.err.println(ex);
         * }
         * }
         */
        final List<String> stringsCollection = STRINGS_COLLECTION.getStringsCollection();

        return stringsCollection;
    }
}

class StringsCollectionRunnable implements Runnable {

    /*
     * Implement the runnable for adding threadName with index
     */
    private final int stringsCount;

    private final String threadName;

    private final StringsCollection stringsCollection;

    public StringsCollectionRunnable(final StringsCollection stringsCollection, final int stringsCount, final String threadName) {

        this.stringsCollection = stringsCollection;
        this.stringsCount = stringsCount;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        ThreadStringCollector.getStrings(stringsCount, stringsCollection.getStringsCollection());
    }

}

class StringsCollection {

    java.util.List<String> list = java.util.Collections.synchronizedList(new java.util.ArrayList<>());

    public void addString(final String string) {

        list.add(string);
    }

    public java.util.List<String> getStringsCollection() {

        return list;
    }

    public void clear() {

        list.clear();
        list = java.util.Collections.synchronizedList(new java.util.ArrayList<>());
    }

}
