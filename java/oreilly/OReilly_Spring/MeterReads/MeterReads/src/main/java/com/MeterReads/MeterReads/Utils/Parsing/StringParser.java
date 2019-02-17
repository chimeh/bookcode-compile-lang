package com.MeterReads.MeterReads.Utils.Parsing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;

/**
 * This is a class used for wrapping up parsing strings
 * to different forms.
 */
public class StringParser {

    /**
     * These two represent the strings we use to create an exception message
     * to feed back. They are defined here so they can be used in tests to check
     * the exception message is correct.
     */
    protected static final String EXCEPTION_PREFIX = "String ";
    protected static final String EXCEPTION_SUFFIX = " could not be parsed";

    /**
     * This parses a string to a long
     *
     * @param input String that we would like parsed
     *
     * @return The long equivalent of the string.
     */
    public static long parseLong(String input) throws MeterReadsException {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new MeterReadsException(EXCEPTION_PREFIX + input + EXCEPTION_SUFFIX, e);
        }
    }

}
