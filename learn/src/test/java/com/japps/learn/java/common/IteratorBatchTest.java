/*
* $Id: IteratorBatchTest.java 01-Feb-2022 11:53:45 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * The IteratorBatchTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class IteratorBatchTest {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {

       System.out.println(Files.lines(Path.of("M:\\Development\\LearnDocs\\testData\\Intermediair_DWHAGT_PLX_20220119_D_BlankLinesAtEnd.csv")).count());
       System.out.println(Files.lines(Path.of("M:\\Development\\LearnDocs\\testData\\Intermediair_DWHAGT_PLX_20220119_D.csv")).count());
       System.out.println(Files.lines(Path.of("M:\\Development\\LearnDocs\\testData\\Intermediair_DWHAGT_PLX_20220119_D_EMPTY.csv")).count());
       System.out.println(Files.lines(Path.of("M:\\Development\\LearnDocs\\testData\\Intermediair_DWHAGT_PLX_20220119_D_InvalidData.csv")).count());


        // TODO Auto-generated method stub
        final String dateStr = "20220127";

        final LocalDateTime dateTime =
        LocalDateTime.of(LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0, 0, 0));
        System.out.println(dateTime);

    }

    private static Iterator<Integer> buildIterator() {
    // TODO
        return null;
    }

}
