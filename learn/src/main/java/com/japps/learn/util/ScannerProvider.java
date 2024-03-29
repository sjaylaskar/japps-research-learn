/*
 * $Id: ScannerProvider.java 06-May-2021 3:16:37 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

import java.util.Scanner;


/**
 * The scanner provider.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ScannerProvider {

    /** The scanner. */
    private Scanner scanner;

    /** The is closed. */
    private boolean isClosed;

    private static ScannerProvider scannerProvider;

    /**
     * Instantiates a new scanner provider.
     */
    private ScannerProvider() {

        scanner = newScanner();
    }

    /**
     * New scanner.
     *
     * @return the scanner
     */
    private Scanner newScanner() {

        return new Scanner(System.in);
    }

    /**
     * New instance.
     *
     * @return the scanner provider
     */
    public static ScannerProvider instance() {

        if (scannerProvider == null) {
            scannerProvider = new ScannerProvider();
        }

        return scannerProvider;
    }

    /**
     * Scanner.
     *
     * @return the scanner
     */
    public Scanner scanner() {

        if (isClosed || scanner == null) {
            scanner = newScanner();
        }

        return scanner;
    }

    /**
     * Close.
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
        isClosed = true;
    }
}
