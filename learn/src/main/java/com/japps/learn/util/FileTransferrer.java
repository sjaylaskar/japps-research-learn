/*
* Id: FileTransferrer.java 30-Nov-2021 2:28:10 am SubhajoyLaskar
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

/**
 * The file transferrer.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class FileTransferrer implements Loggable {

    private static final String SOURCE_PATH_2020 = "data/2020";
    private static final String DESTINATION_PATH_2020 = "src/main/resources/com/japps/adventofcode/probs2020";

    private static final String SOURCE_PATH_2021 = "data/2021";
    private static final String DESTINATION_PATH_2021 = "src/main/resources/com/japps/adventofcode/probs2021";

    private static final Map<String, String> SRC_DEST_MAP = new HashMap<>();

    static {
        SRC_DEST_MAP.put(SOURCE_PATH_2020, DESTINATION_PATH_2020);
        SRC_DEST_MAP.put(SOURCE_PATH_2021, DESTINATION_PATH_2021);
    }

    private static int count;

    private FileTransferrer() {

    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String ...args) {
        SRC_DEST_MAP.forEach((src, dest) -> {
            final Path sourcePath = Paths.get(src);
            final Path destinationPath = Paths.get(dest);
            listAndCopy(sourcePath, destinationPath);
            Loggable.INFO(FileTransferrer.class, "Number of files copied from: " + src + " is: " + count);
            count = 0;
        });
    }

    private static void listAndCopy(final Path sourcePath, final Path destinationPath) {

        try {
            Files.list(sourcePath).forEach(sourceFile -> copy(sourceFile, destinationPath));
        } catch (final IOException exception) {
            Loggable.ERROR(FileTransferrer.class, exception.getLocalizedMessage());
            throw new RuntimeException(exception);
        }
    }

    /**
     * Copy.
     *
     * @param sourceFile the source file
     * @param destinationPath the destination path
     * @return the path
     */
    private static synchronized void copy(final Path sourceFile, final Path destinationPath) {

        try {
            final Path resolveDestinationFilePath = resolve(sourceFile, destinationPath);
            if (Files.notExists(resolveDestinationFilePath)) {
                Files.copy(sourceFile,
                    resolveDestinationFilePath,
                    StandardCopyOption.REPLACE_EXISTING);
                Loggable.INFO(FileTransferrer.class, "Copied file: " + sourceFile);
                ++count;
            }
        } catch (final IOException exception) {
            Loggable.ERROR(FileTransferrer.class, exception.getLocalizedMessage());
            throw new RuntimeException(exception);
        }
    }

    /**
     * Resolve.
     *
     * @param sourceFile the source file
     * @param destinationPath the destination path
     * @return the path
     */
    private static Path resolve(final Path sourceFile, final Path destinationPath) {

        return destinationPath.resolve(sourceFile.getFileName());
    }
}
