/*
* $Id: FileDiffLinesFinder.java 28-Jul-2022 12:04:33 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The file diff lines finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class FileDiffLinesFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws URISyntaxException the URI syntax exception
     */
    public static void main(final String[] args) throws IOException, URISyntaxException {
        /*
         * final Set<String> file1LinesSet = Files.lines(Paths.get(
         * "M:\\Development\\Code\\Repositories\\japps-research-learn\\japps-research-learn\\learn\\src\\main\\resources\\com\\japps\\learn\\data\\classes1.txt"
         * ))
         * .collect(Collectors.toSet());
         */

        final Map<String, Long> frequencyOfFile2Lines = Files.lines(Paths.get(
                "M:\\Development\\Code\\Repositories\\japps-research-learn\\japps-research-learn\\learn\\src\\main\\resources\\com\\japps\\learn\\data\\classes2.txt"))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        findDiff(frequencyOfFile2Lines);

    }

    /**
     * Finds the diff.
     *
     * @param file1 the file 1
     * @param file2 the file 2
     */
    private static void findDiff(final Map<String, Long> frequencyOfFileLines) {

        System.out.println(frequencyOfFileLines.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Entry::getKey).collect(Collectors.joining("\n")));

    }


}
