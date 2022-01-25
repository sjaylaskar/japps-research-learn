/*
* Id: Solvable.java 01-Dec-2021 12:26:02 pm SubhajoyLaskar
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The solvable.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public interface Solvable {

    /**
     * Determines the input file path.
     *
     * @return the input file path
     */
    default String determineInputFilePath() {
        return ProblemSolverUtil.determineInputFilePath(getClass());
    }

    /**
     * Lines.
     *
     * @return the list of lines
     * @throws IOException Signals that an I/O exception has occurred.
     */
    default List<String> lines() throws IOException {

        try (final Stream<String> fileLinesStream = Files.lines(Paths.get(determineInputFilePath()))) {
            return fileLinesStream.collect(Collectors.toList());
        }
    }

    /**
     * Read file bytes.
     *
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     */
    default byte[] readFileBytes() throws IOException {

        return Files.readAllBytes(Paths.get(determineInputFilePath()));
    }

    /**
     * Decimalize.
     *
     * @param binaryString the binary string
     * @return the decimal value
     */
    default long decimalize(final String binaryString) {

        return Long.parseLong(binaryString, 2);
    }
}
