package com.MeterReads.MeterReads.Utils.Exceptions;

/**
 * This is a custom exception class that is used to handle exceptions
 * within the program. Rather than throw different exception types all
 * over we tend to throw just this one.
 */
public class MeterReadsException extends Throwable {

    /**
     * Constructor for the exception with just a message. This passes directly
     * to the throwable constructor.
     *
     * @param exceptionMessage The message we want to add to the exception
     */
    public MeterReadsException(String exceptionMessage) {
        super(exceptionMessage);
    }

    /**
     * Constructor for the exception with a message and a causing exception. This
     * passes directly to the throwable constructor.
     *
     * @param exceptionMessage The message to add to the exception
     * @param causingException The causing exception to add to the exception
     */
    public MeterReadsException(String exceptionMessage, Exception causingException) {
        super(exceptionMessage, causingException);
    }

}
