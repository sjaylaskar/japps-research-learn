/*
 * Id: Loggable.java 30-Nov-2021 3:13:00 am SubhajoyLaskar
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

/**
 * The loggable.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public interface Loggable {

    /**
     * Info.
     *
     * @param message the message
     */
    default void info(final Object message) {

        if (message != null) {
            LogUtil.newInstance(getClass()).info(message.toString());
        }
    }

    /**
     * Error.
     *
     * @param message the message
     */
    default void error(final Object message) {

        if (message != null) {
            LogUtil.newInstance(getClass()).error(message.toString());
        }
    }

    /**
     * Prints the object with a new line at the end.
     *
     * @param object the object
     */
    default void println(final Object object) {
        LogUtil.newInstance(getClass()).println(object);
    }

    /**
     * Info.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @param message the message
     */
    static <T extends Loggable> void INFO(final Class<T> clazz, final Object message) {

        if (message != null) {
            LogUtil.newInstance(clazz).info(message.toString());
        }
    }

    /**
     * Error.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @param message the message
     */
    static <T extends Loggable> void ERROR(final Class<T> clazz, final Object message) {

        if (message != null) {
            LogUtil.newInstance(clazz).error(message.toString());
        }
    }
}
