/*
* $Id: Measurable.java 13-Jan-2022 3:30:35 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;


/**
 * The measurable.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public interface Measurable {

    /**
     * Gets the timer util.
     *
     * @return the timer util
     */
    TimerUtil getTimerUtil();

    /**
     * Start timer.
     */
    default void startTimer() {
        getTimerUtil().start();
    }

    /**
     * Stop timer.
     */
    default void stopTimer() {
        getTimerUtil().stop();
    }

    /**
     * Time elapsed.
     * Resets the timer.
     *
     * @return the time elapsed.
     */
    default long timeElapsed() {
        final long timeElapsed = getTimerUtil().time();
        getTimerUtil().reset();
        System.out.println("Time elapsed: " + timeElapsed + " ms.");
        return timeElapsed;
    }

    /**
     * Reset timer.
     */
    default void resetTimer() {
        getTimerUtil().reset();
    }
}
