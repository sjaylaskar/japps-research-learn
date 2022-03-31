/*
* $Id: Test.java 04-Feb-2022 2:15:49 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.feb.rategain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Test.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class Test {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        final File file = new File("file.txt");
        System.out.println(file.exists());
        final FileWriter fw = new FileWriter(file);
        System.out.println(file.exists());

    }

}
