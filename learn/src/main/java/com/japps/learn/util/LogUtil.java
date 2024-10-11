/*
* Id: AbstractLoggable.java 30-Nov-2021 3:18:18 am SubhajoyLaskar
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The abstract loggable.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class LogUtil {

    /** The log. */
    private final Logger log;

    private boolean isDisabled = false;

    /**
     * Instantiates a new log util.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     */
    private <T extends Loggable> LogUtil(final Class<T> clazz) {
        this.log = LogManager.getLogger(clazz);
    }

    public LogUtil disabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }

    /**
     * New instance.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @return the log util
     */
    public static <T extends Loggable> LogUtil newInstance(final Class<T> clazz) {
        return new LogUtil(clazz);
    }

    /**
     * Info.
     *
     * @param message the message
     */
    public void info(final String message) {
        if (!isDisabled) {
            log.info(message);
        }
    }

    /**
     * Error.
     *
     * @param message the message
     */
    public void error(final String message) {
        if (!isDisabled) {
            log.error(message);
        }

    }

    /**
     * Prints the object with a new line at the end.
     *
     * @param object the object
     */
    public void println(final Object object) {
        if (!isDisabled) {
            printLn(object);
        }
    }

    /**
     *  Prints the object with a new line at the end.
     *
     * @param objects the objects
     */
    public static void printLn(final Object ...objects) {
        if (objects != null && objects.length > 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            for (final Object object : objects) {
                stringBuilder.append(object);
            }
            System.out.println(stringBuilder);
        }
    }

    /**
     * Prints the objects.
     *
     * @param objects the objects
     */
    public static void print(final Object ...objects) {
        if (objects != null && objects.length > 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            for (final Object object : objects) {
                stringBuilder.append(object);
            }
            System.out.print(stringBuilder);
        }
    }
}
