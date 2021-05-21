/*
 * $Id: ThreadDemo1.java 15-Apr-2021 4:05:45 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.multithreading;

/**
 * The ThreadDemo1.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class ThreadDemo1 implements Runnable {

    /** The x. */
    private int x = 0;

    /** The y. */
    private int y = 0;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final ThreadDemo1 obj = new ThreadDemo1();
        (new Thread(obj)).start(); /* Line 8 */
        (new Thread(obj)).start(); /* Line 8 */
    }

    /**
     * Run.
     */
    @Override
    public synchronized void run () /*Line 11*/
    {
        for (int i=0;i<10;i++) /*Line 13*/
        {
          x++;
          y++;
         System.out.println("x = " +x+" ; y = "+y);
        }
    }
}
