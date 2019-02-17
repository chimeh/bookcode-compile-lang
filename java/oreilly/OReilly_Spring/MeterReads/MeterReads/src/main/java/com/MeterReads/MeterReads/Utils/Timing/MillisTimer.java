package com.MeterReads.MeterReads.Utils.Timing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;

/**
 * This class is used for timing different components of the program.
 */
public class MillisTimer {

    /**
     * Exception message returned if the timer finish method is called before it
     * is started.
     */
    protected static final String TIMER_FINISHED_BEFORE_STARTED = "Timer finish before timer started";

    /**
     * Exception message returned if the timer is not finished or started before
     * the get time is called.
     */
    protected static final String TIMER_NOT_USED_CORRECTLY = "Timer must be started and finished before time can be retrieved.";

    /**
     * We can use this to see if the timer has been started as current millis can
     * never be zero.
     */
    private static final long DEFAULT_LONG_TIME = 0;

    private long startTime;
    private long endTime;

    /**
     * This method should be called when we want to start the timer. It
     * assigns the current time in milliseconds to a member variable.
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * This method should be called when we want to finish the timer. It
     * checks to make sure that the timer has been started, if it has then
     * we throw an exception to say the timer hasn't been used correctly. If
     * it has then we assign an end time.
     *
     * @throws MeterReadsException Thrown if the timer hasn't been started before
     * it has finished
     */
    public void finish() throws MeterReadsException {
        if(startTime == DEFAULT_LONG_TIME) {
            throw new MeterReadsException(TIMER_FINISHED_BEFORE_STARTED);
        }
        endTime = System.currentTimeMillis();
    }

    /**
     * This returns the time from the timer. It does this by subtracting the end
     * time from the start time. If the timer hasn't been started or finished
     * correctly it throws an exception.
     *
     * @return The time the timer ran in milliseconds
     *
     * @throws MeterReadsException If the timer was not started or finished correctly
     * it throws an exception.
     */
    public long getTime() throws MeterReadsException {
        if(startTime == DEFAULT_LONG_TIME || endTime == DEFAULT_LONG_TIME) {
            throw new MeterReadsException(TIMER_NOT_USED_CORRECTLY);
        }
        return endTime - startTime;
    }

}
