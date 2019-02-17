package com.MeterReads.MeterReads.Utils.Exceptions;

import org.junit.rules.ExpectedException;

/**
 * This is an exception helper. It gives us a central place to set
 * up expected exceptions for our custom MeterReads type.
 *
 * @see MeterReadsException
 */
public class MeterReadsExceptionTestHelper {

    /**
     * This is used to set up an expected MeterReadsException with a given
     * exception message.
     *
     * @param expectedException The exception we want to set up
     * @param message The message we would like to include in the expected exception.
     */
    public static void expectMessage(ExpectedException expectedException, String message) {
        expectedException.expect(MeterReadsException.class);
        expectedException.expectMessage(message);
    }

}
