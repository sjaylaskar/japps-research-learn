/*
* $Id: Test2.java 04-Jan-2022 10:18:18 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.jan.nice;

import java.io.ByteArrayInputStream;

/**
 * The Test2.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class Test2 {

    public static void main(final String[] args) {

        final String obj = "abc";
        final byte b[]  = obj.getBytes();
        final ByteArrayInputStream obj1 = new ByteArrayInputStream(b);
        for (int i = 0; i < 2; ++i) {
            int c;
            while ((c = obj1.read()) != -1) {
                if (i == 0) {
                    System.out.println(Character.toUpperCase((char) c));
                    //obj2.write(1);
                }
            }
            System.out.println(obj1);
        }
    }
}
