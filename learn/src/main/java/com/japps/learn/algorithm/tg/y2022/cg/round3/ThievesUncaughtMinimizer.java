/*
* $Id: ThievesUncaughtMinimizer.java 24-Jul-2022 3:23:57 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.cg.round3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The ThievesUncaughtMinimizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ThievesUncaughtMinimizer {

   /**
    * The main method.
    *
    * @param args the arguments
    * @throws Exception the exception
    */
   public static void main(final String[] args) throws Exception {
      final Scanner scanner = new Scanner(System.in);

      final int p = scanner.nextInt();
      final int s = scanner.nextInt();
      final int n = scanner.nextInt();

      scanner.nextLine();

      final List<Integer> criminalReachTimes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

      final List<Integer> criminalReachLocations = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

      final List<Criminal> criminals = new ArrayList<>();

      for (int i = 1; i <= n; i++) {
           criminals.add(new Criminal(i, criminalReachTimes.get(i - 1), criminalReachLocations.get(i - 1)));
      }

      final List<Integer> times = criminals.stream().map(Criminal::getTime).collect(Collectors.toSet()).stream().sorted().collect(Collectors.toList());

      final Map<Integer, List<Criminal>> criminalsByTime = criminals.stream().collect(Collectors.groupingBy(Criminal::getTime));

      final int pos = p;
      final int arrestedCount = 0;

      for (final int time : times) {
          final List<Criminal> criminalsAtTime = criminalsByTime.get(time);
          for (int i = 0; i < criminalsAtTime.size(); i++) {

          }
      }

      /*int pos = p;
      int arrestedCount = 0;
      for (int i = 0; i < n; i++) {
           if (isInRange(criminals.get(i), pos, s, (i == 0) ? 0 : criminals.get(i - 1).time)) {
               arrestedCount++;
               pos = criminals.get(i).location;
           }
      }*/

      System.out.println(n - arrestedCount);

      scanner.close();
   }

   /**
    * The criminal.
    *
    * @author Subhajoy Laskar
    * @version 1.0
    */
   private static final class Criminal {

      /** The index. */
      private final int index;

      /** The time. */
      private final int time;

      /** The location. */
      private final int location;

      /**
       * Instantiates a new criminal.
       *
       * @param index the index
       * @param time the time
       * @param location the location
       */
      Criminal(final int index, final int time, final int location) {
         this.index = index;
         this.time = time;
         this.location = location;
      }


    /**
     * @return the index
     */
    int getIndex() {

        return index;
    }


    /**
     * @return the time
     */
    int getTime() {

        return time;
    }


    /**
     * @return the location
     */
    int getLocation() {

        return location;
    }


   }

   /**
    * Checks if is in range.
    *
    * @param criminal the criminal
    * @param position the position
    * @param speed the speed
    * @param previousTime the previous time
    * @return true, if is in range
    */
   private static boolean isInRange(final Criminal criminal, final int position, final int speed, final int previousTime) {
      final int displacement = speed * (criminal.time - previousTime);
      final int copLocation1 = position + displacement;
      final int copLocation2 = position - displacement;
      return ((position <= criminal.location && criminal.location <= copLocation1)
          || (copLocation2 <= criminal.location && criminal.location <= position));
   }
}
