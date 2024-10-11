/*
* $Id: CertificationTest1.java 06-Apr-2021 2:00:42 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hrank;


/**
 * The CertificationTest1.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CertificationTest1 {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        //ImplC.main(null);

        try {
            final float f1 = Float.parseFloat("3.0");
            final int x = (int) f1;
            final byte b = (byte) f1;
            final double d = (double) f1;
            System.out.println(x + b + d);
        } catch (final NumberFormatException exception) {
            System.out.println("Bad number");
        }
    }
}

interface BaseI {

    void method();
}

class BaseC {
    public void method() {
        System.out.println("BaseC");
    }
}

class ImplC extends BaseC implements BaseI {
    public static void main(final String[] args) {

        new ImplC().method();
    }
}