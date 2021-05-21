/*
 * $Id: ThreadDemo6.java 15-Apr-2021 4:30:48 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.multithreading;

/**
 * The ThreadDemo6.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class ThreadDemo6 {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        new MyThread2().start();
        new MyThread2(new RunnableDemo()).start();
    }
}

class MyThread2 extends Thread {

    MyThread2() {

    }

    MyThread2(final Runnable r) {

        super(r);
    }

    @Override
    public void run() {

        System.out.print("Inside Thread ");
    }
}

class RunnableDemo implements Runnable {

    @Override
    public void run() {

        System.out.print(" Inside Runnable");
    }
}
