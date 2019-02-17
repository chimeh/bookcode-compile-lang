package com.MeterReads.MeterReads.Utils.DateTime;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;

/**
 * This is a utilities class used for all date/ time operations
 */
public class DateTimeUtils {

    /**
     * Exception message thrown if we can't parse a date.
     */
    protected static final String COULD_NOT_PARSE_DATE = "Could not parse read date, incorrect format.";

    /**
     * The formatter we use to parse incoming strings
     */
    private static final DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXXVV");

    /**
     * The formatter we use to format outgoing strings
     */
    private static final DateTimeFormatter TO_STRING_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxxx'Z'");

    /**
     * A method used to parse ISO8601 date strings. It uses a custom formatter
     * to allow for offsets as well as the specification of timezones.
     *
     * @param dateString The string to be parsed as a date
     *
     * @return The parsed datetime.
     */
    public static OffsetDateTime parseISO8601Date(String dateString) throws MeterReadsException {
        try {
            return OffsetDateTime.parse(dateString, PARSE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new MeterReadsException(COULD_NOT_PARSE_DATE, e);
        }
    }

    /**
     * A method used to convert the OffsetDateTime to a string formatted by the ISO8601 standard
     *
     * @param offsetDateTime The OffseetDateTime to format
     *
     * @return A string of ISO8601 standard formatted from the OffsetDateTime
     */
    public static String convertOffsetDateTimeToISO8601DateString(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(TO_STRING_FORMATTER);
    }

}
