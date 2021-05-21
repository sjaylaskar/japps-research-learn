/*
 * $Id: ThreadDemo5.java 15-Apr-2021 4:27:31 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.multithreading;

/**
 * The ThreadDemo5.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class ThreadDemo5 implements Runnable {

    /** The y. */
    String x, y;

    /**
     * Run.
     */
    @Override
    public void run()
    {
        for(int i = 0; i < 10; i++) {
            synchronized(this)
            {
                x = "Hello";
                y = "Java";
              System.out.print(x + " " + y + " ");
            }
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String args[]) {

        final ThreadDemo5 run = new ThreadDemo5();
        final Thread obj1 = new Thread(run);
        final Thread obj2 = new Thread(run);
        obj1.start();
        obj2.start();
    }
}
