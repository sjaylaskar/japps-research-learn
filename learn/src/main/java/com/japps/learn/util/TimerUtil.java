/*
* $Id: TimerUtil.java 13-Jan-2022 3:15:15 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

import org.apache.commons.lang3.time.StopWatch;

/**
 * The timer util.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TimerUtil {

    /** The timer. */
    private final Timer timer;

    /**
     * Instantiates a new timer util.
     */
    private TimerUtil() {
        timer = new Timer();
    }

    /**
     * Instance.
     *
     * @return the timer util
     */
    public static TimerUtil instance() {
        return new TimerUtil();
    }

    /**
     * Start.
     */
    public void start() {
        timer.start();
    }

    /**
     * Stop.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Time.
     *
     * @return the long
     */
    public long time() {
        return timer.time();
    }

    /**
     * Reset.
     */
    public void reset() {
        timer.reset();
    }

    /**
     * The timer.
     */
    private static final class Timer {

        /** The watch. */
        private final StopWatch watch = new StopWatch();

        /**
         * Start.
         */
        private void start() {
            watch.start();
        }

        /**
         * Stop.
         */
        private void stop() {
            watch.stop();
        }

        /**
         * Time.
         *
         * @return the long
         */
        private long time() {
            return watch.getTime();
        }

        /**
         * Reset.
         */
        private void reset() {
            watch.reset();
        }
    }
}
