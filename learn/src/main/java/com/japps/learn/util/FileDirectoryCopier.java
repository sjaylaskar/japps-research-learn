/*
 * $Id: FileDirectoryCopier.java 17-Apr-2022 1:39:13 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;


/**
 * The FileDirectoryCopier.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class FileDirectoryCopier implements Loggable {

    /** The src path. */
    private static final String SRC_PATH_PREFIX = "ONEPLUS A6000\\Internal shared storage\\";
    private static final List<String> SRC_PATHS = Arrays.asList("bluetooth", "DCIM", "Download", "Pictures");

    /** The dest path. */
    private static final String DEST_PATH = "E:\\PhoneStuff\\OnePlus6_Jay";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        copy();
    }

    /**
     * Copy.
     */
    public static void copy() {

        try {
            for (final String srcPath : SRC_PATHS) {
                copyToDest(srcPath);
            }
        } catch (final Exception exception) {
            Loggable.ERROR(FileDirectoryCopier.class, ExceptionUtils.getRootCause(exception).getLocalizedMessage());
            throw new RuntimeException(exception);
        }
    }

    /**
     * @param srcPath
     * @throws IOException
     */
    private static void copyToDest(final String srcPath) throws IOException {

        final String srcFullPath = SRC_PATH_PREFIX + srcPath;
        final LocalDateTime startTime = LocalDateTime.now();
        Loggable.INFO(FileDirectoryCopier.class, "Copy started at: " + startTime);
        final long startTimeMillis = System.currentTimeMillis();
        copyDirectory(srcFullPath, DEST_PATH);
        final long endTimeMillis = System.currentTimeMillis();
        final LocalDateTime endTime = LocalDateTime.now();
        Loggable.INFO(FileDirectoryCopier.class, "Copy ended at: " + endTime);
        Loggable.INFO(FileDirectoryCopier.class, "Copied successfully from: " + srcFullPath + " to: " + DEST_PATH);
        final long timeElapsedMillis = endTimeMillis - startTimeMillis;
        Loggable.INFO(FileDirectoryCopier.class, "Time elapsed: " + timeElapsedMillis + " ms.");
        Loggable.INFO(FileDirectoryCopier.class, "Time elapsed: " + timeElapsedMillis / 1000 + " seconds.");
        Loggable.INFO(FileDirectoryCopier.class, "Time elapsed: " + timeElapsedMillis / 60000 + " minutes.");
    }

    /**
     * Copy directory.
     *
     * @param sourceDirectoryLocation the source directory location
     * @param destinationDirectoryLocation the destination directory location
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void copyDirectory(final String sourceDirectoryLocation, final String destinationDirectoryLocation)
            throws IOException {

        final File sourceDirectory = new File(sourceDirectoryLocation);
        final File destinationDirectory = new File(destinationDirectoryLocation);
        FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
    }
}
