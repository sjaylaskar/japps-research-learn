/*
* $Id: StreamTest.java 29-Jun-2021 12:05:16 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.y2021.jun.qpro;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The StreamTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StreamTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
       final Stream<double[]> hackValue = IntStream.rangeClosed(1, 100).boxed()
               .flatMap(a -> IntStream.rangeClosed(a, 10)
                .mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0));

       hackValue.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

}
