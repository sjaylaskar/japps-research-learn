/*
 * $Id: Data.java 20-Jan-2022 8:27:47 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common.biconsumer;

/**
 * The Data.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class Data {

    /** The code. */
    private String code;

    /** The data. */
    private String data;

    /**
     * Instantiates a new data.
     *
     * @param code the code
     * @param data the data
     */
    Data(final String code, final String data) {

        this.code = code;
        this.data = data;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    String getCode() {

        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    void setCode(final String code) {

        this.code = code;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    String getData() {

        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    void setData(final String data) {

        this.data = data;
    }

}
