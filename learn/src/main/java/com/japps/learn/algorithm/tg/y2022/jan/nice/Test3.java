/*
* $Id: Test3.java 04-Jan-2022 10:24:25 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.jan.nice;


/**
 * The Test3.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class Test3 {
    public static void main(final String[] args) {

        final B obj2 = new B();
        obj2.i = 1;
        obj2.j = 2;
        A r;
        r = obj2;
        r.display();
    }
}

class A {
    int i;
    public void display() {
        System.out.println(i);
    }
}

class B extends A {
    int j;
    @Override
    public void display() {
        System.out.println(j);
    }
}

class DynamicDispatch {

}