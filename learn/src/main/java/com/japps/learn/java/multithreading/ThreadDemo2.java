/*
* $Id: ThreadDemo22.java 15-Apr-2021 4:11:29 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.multithreading;


/**
 * The ThreadDemo22.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class ThreadDemo2 implements Runnable
{
    
    /** The y. */
    int x = 0, y = 0;
    
    /**
     * Adds the X.
     *
     * @return the int
     */
    int addX() {x++; return x;}
    
    /**
     * Adds the Y.
     *
     * @return the int
     */
    int addY() {y++; return y;}

    /**
     * Run.
     */
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println( Thread.currentThread().getName() + ": " +addX() + " " + addY());
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String args[])
    {
        final ThreadDemo2 obj1 = new ThreadDemo2();
        final ThreadDemo2 obj2 = new ThreadDemo2();
        final Thread t1 = new Thread(obj1);
        final Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}