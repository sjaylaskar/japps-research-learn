/*
* $Id: ThreadDemo33.java 15-Apr-2021 4:17:33 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.multithreading;


/**
 * The ThreadDemo33.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class ThreadDemo3 extends Thread
{

    /** The sb 1. */
    final StringBuffer sb1 = new StringBuffer();

    /** The sb 2. */
    final StringBuffer sb2 = new StringBuffer();

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String args[])
    {
        final ThreadDemo3 h = new ThreadDemo3();

        new Thread()
        {
            @Override
            public void run()
            {
                synchronized(this)
                {
                    h.sb1.append("Java");
                    h.sb2.append("Thread");
                    System.out.println(h.sb1);
                    System.out.println(h.sb2);
                }
            }
        }.start();

        new Thread()
        {
            @Override
            public void run()
            {
                synchronized(this)
                {
                    h.sb1.append("Mutithreading");
                    h.sb2.append("Example");
                    System.out.println(h.sb2);
                    System.out.println(h.sb1);
                }
            }
        }.start();
    }
}