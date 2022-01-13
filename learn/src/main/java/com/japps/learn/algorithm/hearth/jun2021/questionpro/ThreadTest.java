/*
* $Id: ThreadTest.java 29-Jun-2021 12:10:17 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.jun2021.questionpro;


/**
 * The ThreadTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ThreadTest extends Thread {

    /**
     * Run.
     */
    @Override
    public void run() {
        System.out.println(getName());
        for (int h = 1; h <= 3; h++) {
            try {
                Thread.sleep(10);
            } catch (final Exception exception) {
                System.out.println("hello");
            }
            System.out.println(h + " ");
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final ThreadTest h1 = new ThreadTest();
        h1.setName("h1");
        final ThreadTest h2 = new ThreadTest();
        h2.setName("h2");
        h1.setPriority(MAX_PRIORITY);
        h2.setPriority(MIN_PRIORITY);
        h1.start();
        try {
            h1.join();
        } catch (final Exception exception) {
            System.out.println("hi");
        }
        h2.start();
    }

}
