/*
* $Id: ThreadDemo4.java 15-Apr-2021 4:25:16 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.multithreading;


/**
 * The ThreadDemo4.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class ThreadDemo4
{
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main (final String [] args)
    {
        final Thread t = new MyThread2()
        {
            @Override
            public void run()
            {
                System.out.println(" foo");
            }
        };
        t.start();
    }
}
class MyThread extends Thread
{
    MyThread()
    {
        System.out.print(" MyThread");
    }
    @Override
    public void run()
    {
        System.out.print(" bar");
    }
    public void run(final String s)
    {
        System.out.println(" baz");
    }
}