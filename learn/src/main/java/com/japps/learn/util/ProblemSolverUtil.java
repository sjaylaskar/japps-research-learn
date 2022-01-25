/*
* Id: ProblemSolverUtil.java 01-Dec-2021 11:51:25 am SubhajoyLaskar
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * The problem solver util.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class ProblemSolverUtil implements Loggable {

    /** The txt file extension. */
    private static final String TXT_FILE_EXTENSION = ".txt";

    /** The input. */
    private static final String INPUT = "input";

    /** The src main resources. */
    private static final String SRC_MAIN_RESOURCES = "src/main/resources/";

    /**
     * Instantiates a new problem solver util.
     */
    private ProblemSolverUtil() {

    }

    /**
     * Determines the input file path.
     *
     * @param clazz the clazz
     * @return the input file path
     */
    public static String determineInputFilePath(final Class<?> clazz) {
        final String inputFileSuffix = clazz.getSimpleName().substring(4, 6);

        final String inputFileName = determineInputFileDirectoryPath(clazz) + "/" + (INPUT + (NumberUtils.isCreatable(inputFileSuffix.substring(1)) ? inputFileSuffix : inputFileSuffix.substring(0, 1)) + TXT_FILE_EXTENSION);
        Loggable.INFO(ProblemSolverUtil.class, "Input file: " + inputFileName);
        return inputFileName;
    }

    /**
     * Determines the input file directory path.
     *
     * @param clazz the clazz
     * @return the input file directory path
     */
    private static String determineInputFileDirectoryPath(final Class<?> clazz) {

        return SRC_MAIN_RESOURCES + clazz.getPackageName().replace(".", "/");
    }
}
