package com.designpatterns.chp3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**

 */
public class LowerCase {

    private final static Logger logger = LoggerFactory.getLogger(LowerCase.class);

    public static String getContents(String filename){
        int character;
        StringBuilder stringBuilder = new StringBuilder();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try {
            InputStream in = new LowerCaseInputStream(loader.getResourceAsStream(filename));
            while((character = in.read()) >= 0){
                stringBuilder.append(String.valueOf((char)character));
            }
            in.close();
        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("Oops! The following error occurred: ", fileNotFoundException);
        } catch (IOException ioException) {
            logger.error("Oops! The following error occurred: ", ioException);
        }
        return stringBuilder.toString();
    }
}
