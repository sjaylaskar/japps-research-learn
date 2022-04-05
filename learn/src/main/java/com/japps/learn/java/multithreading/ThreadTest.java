/*
 * Id: ThreadTest.java 06-Apr-2022 1:47:40 am SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.multithreading;

/**
 * The thread test.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class ThreadTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        thread.setName("Test");
        System.out.println(thread.getName());
    }

}
