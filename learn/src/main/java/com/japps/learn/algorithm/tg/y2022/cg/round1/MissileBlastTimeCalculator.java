/*
 * $Id: MissileBlastTimeCalculator.java 01-Apr-2022 1:25:07 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.cg.round1;

import java.time.LocalTime;
import java.util.Scanner;


/**
 * The missile blast time calculator.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MissileBlastTimeCalculator {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final LocalTime launchTime = LocalTime.parse(scanner.nextLine().replace(" ", ":"));

        final String[] travelTimeHhMm = scanner.nextLine().split(" ");

        System.out.println(
            launchTime.plusHours(Long.parseLong(travelTimeHhMm[0])).plusMinutes(Long.parseLong(travelTimeHhMm[1])).toString().replace(":", " "));

        scanner.close();
    }

}
