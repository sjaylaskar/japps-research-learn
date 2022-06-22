/*
 * $Id: StaticOverloadsTester.java 22-Jun-2022 10:02:38 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.general;

/**
 * The StaticOverloadsTester.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StaticOverloadsTester {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Class1 c = new Class2();
        c.show();

    }

}

class Class1 {

    public static void show() {

        System.out.println("In class 1: show().");
    }
}

class Class2 extends Class1 {

    public static void show() {

        System.out.println("In class 2: show().");
    }
}
