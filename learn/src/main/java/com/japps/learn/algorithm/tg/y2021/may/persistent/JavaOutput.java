/*
* $Id: JavaOutput.java 17-May-2021 2:53:14 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2021.may.persistent;

import java.util.HashMap;
import java.util.Map;

/**
 * The JavaOutput.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class JavaOutput {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        /*
         * final Map<String, String> map = new HashMap<>();
         * final String one = "Barclays";
         * final String two = "Barclays";
         * final String three = new String("Barclays");
         * final StringBuilder four = new StringBuilder("Barclays");
         * map.put(one, one);
         * map.put(two, two);
         * map.put(three, three);
         * map.put(four.toString(), four.toString());
         * System.out.println(map.size());
         */

        /*
         * final Student s1 = new Student(3);
         * final Student[] sa = go(s1, new Student(5));
         * sa[0] = s1;
         * for (final Student s : sa) {
         * System.out.print(s.age + " ");
         * }
         */

        final Mammal h = new Horse();
        final Cattle c = new Horse();
        c.eat(h);
        //new Horse().eat(h);
    }

    /**
     * Go.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the student[]
     */
    static Student[] go(final Student s1, final Student s2) {

        s1.age = 2;
        final Student[] sa = {s2, s1};
        return sa;
    }

}

class Student {
    int age;

    Student(final int age) {
        this.age = age;
    }
}

class Mammal {
    void eat(final Mammal m) {
        System.out.println("Mammal eats food");
    }
}

class Cattle extends Mammal {
    void eat(final Cattle c) {
        System.out.println("Cattle eats hay");
    }
}

class Horse extends Cattle {
    void eat(final Horse h) {
        System.out.println("Horse eats hay");
    }
}


