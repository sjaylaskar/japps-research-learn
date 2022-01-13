/*
* $Id: AbstractMeasurable.java 13-Jan-2022 3:34:03 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;


/**
 * The abstract measurable.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public abstract class AbstractMeasurable implements Measurable {

    /** The timer util. */
    private final TimerUtil timerUtil;

    /**
     * Instantiates a new abstract measurable.
     */
    public AbstractMeasurable() {
        timerUtil = TimerUtil.instance();
    }

    @Override
    public TimerUtil getTimerUtil() {
        return timerUtil;
    }
}
