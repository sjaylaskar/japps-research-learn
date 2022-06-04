/*
* $Id: RoundTest.java 05-May-2022 12:59:28 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.jdk8;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The RoundTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class RoundTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final BigDecimal num1 = new BigDecimal("12.1256");
        final BigDecimal num2 = new BigDecimal("12.1245");
        final BigDecimal num3 = new BigDecimal("12.1264");
        final BigDecimal num4 = new BigDecimal("12.10945");

        System.out.println(num1.setScale(3, RoundingMode.HALF_UP).doubleValue());
        System.out.println(num2.setScale(3, RoundingMode.HALF_UP).doubleValue());
        System.out.println(num3.setScale(3, RoundingMode.HALF_UP).doubleValue());
        System.out.println(num4.setScale(3, RoundingMode.HALF_UP).doubleValue());
    }

}
