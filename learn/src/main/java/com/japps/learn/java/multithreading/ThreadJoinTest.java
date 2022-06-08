/*
 * $Id: ThreadJoinTest.java 04-Jun-2022 8:15:42 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.multithreading;

import com.japps.learn.util.LogUtil;


/**
 * The thread join test.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ThreadJoinTest {

    private final static Object LOCK = new Object();

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(final String[] args) throws InterruptedException {

        final Thread thread1 = new Thread(new ThreadRunnable1());
        thread1.setName("ThreadRunnable1-Thread1");
        final Thread thread2 = new Thread(new ThreadRunnable2());
        thread2.setName("ThreadRunnable2-Thread2");

        thread1.start();
        LogUtil.printLn("thread1.isAlive(): " + thread1.isAlive());
        thread1.join(2000);
        LogUtil.printLn("thread1.isAlive(): " + thread1.isAlive());

        thread2.start();
        LogUtil.printLn("thread2.isAlive(): " + thread2.isAlive());
        thread2.join(2000);
        LogUtil.printLn("thread2.isAlive(): " + thread2.isAlive());
    }

    /**
     * Action 1.
     *
     * @throws InterruptedException the interrupted exception
     */
    private static void action1() throws InterruptedException {

        synchronized (LOCK/* ThreadJoinTest.class */) {
            System.out.println("Action1: " + Thread.currentThread().getName());
            LOCK.wait(5000);
        }
    }

    /**
     * Action 2.
     *
     * @throws InterruptedException the interrupted exception
     */
    private void action2() throws InterruptedException {

        synchronized (LOCK/* ThreadJoinTest.class */) {
            LOCK.wait(5000);
            System.out.println("Action2: " + Thread.currentThread().getName());
        }
    }

    /**
     * Invoke action 2.
     *
     * @throws InterruptedException the interrupted exception
     */
    private static void invokeAction2() throws InterruptedException {

        new ThreadJoinTest().action2();
    }

    /**
     * The thread runnable 1.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static final class ThreadRunnable1 implements Runnable {

        /**
         * Run.
         */
        @Override
        public void run() {

            System.out.println("ThreadRunnable1.");
            try {
                action1();
                invokeAction2();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * The thread runnable 2.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static final class ThreadRunnable2 implements Runnable {

        /**
         * Run.
         */
        @Override
        public void run() {

            System.out.println("ThreadRunnable2.");
            try {
                action1();
                invokeAction2();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
