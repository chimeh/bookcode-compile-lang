package com.MeterReads.MeterReads.Utils.DateTime;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsExceptionTestHelper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.OffsetDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * This is used to test all of the DateTimeUtils
 *
 * @see DateTimeUtils
 */
public class DateTimeUtilsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseISO8601Date_StandardDate_ParsesCorrectly() throws MeterReadsException {
        assertThat(DateTimeUtils.parseISO8601Date("2017-11-20T16:19:48+00:00Z"), is(OffsetDateTime.parse("2017-11-20T16:19:48+00:00")));
    }

    @Test
    public void parseISO8601Date_EndDate_ParsesCorrectly() throws MeterReadsException {
        assertThat(DateTimeUtils.parseISO8601Date("9999-12-31T23:59:59+00:00Z"), is(OffsetDateTime.parse("9999-12-31T23:59:59+00:00")));
    }

    @Test
    public void parseISO8601Date_Offset_ParsesCorrectly() throws MeterReadsException {
        assertThat(DateTimeUtils.parseISO8601Date("2017-11-20T16:19:48+01:00Z"), is(OffsetDateTime.parse("2017-11-20T16:19:48+01:00")));
    }

    @Test
    public void parseISO8601Date_InvalidYear_DoesNotParse() throws MeterReadsException {
        parseISO8601Date_Invalid(DateTimeUtils.COULD_NOT_PARSE_DATE, "10000-11-20T16:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidMonth_DoesNotParse() throws MeterReadsException {
        parseISO8601Date_Invalid(DateTimeUtils.COULD_NOT_PARSE_DATE, "2017-13-20T16:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidDay_DoesNotParse() throws MeterReadsException {
        parseISO8601Date_Invalid(DateTimeUtils.COULD_NOT_PARSE_DATE, "2017-11-99T16:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidHour_DoesNotParse() throws MeterReadsException {
        parseISO8601Date_Invalid(DateTimeUtils.COULD_NOT_PARSE_DATE, "2017-11-01T99:19:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidMinute_DoesNotParse() throws MeterReadsException {
        parseISO8601Date_Invalid(DateTimeUtils.COULD_NOT_PARSE_DATE, "2017-11-01T19:99:48+00:00Z");
    }

    @Test
    public void parseISO8601Date_InvalidSecond_DoesNotParse() throws MeterReadsException {
        parseISO8601Date_Invalid(DateTimeUtils.COULD_NOT_PARSE_DATE, "2017-11-01T19:19:99+00:00Z");
    }

    @Test
    public void convertOffsetDateTimeToISO8601DateString_ValidDate_FormatsCorrectly() throws MeterReadsException {
        String readDateString = "2017-11-20T16:19:48+00:00Z";
        OffsetDateTime offsetDateTime = DateTimeUtils.parseISO8601Date(readDateString);
        assertThat(DateTimeUtils.convertOffsetDateTimeToISO8601DateString(offsetDateTime), is(readDateString));
    }

    @Test
    public void convertOffsetDateTimeToISO8601DateString_OffsetDate_FormatsCorrectly() throws MeterReadsException {
        String readDateString = "2017-11-20T16:19:48+01:00Z";
        OffsetDateTime offsetDateTime = DateTimeUtils.parseISO8601Date(readDateString);
        assertThat(DateTimeUtils.convertOffsetDateTimeToISO8601DateString(offsetDateTime), is(readDateString));
    }

    /*
    Utilities
     */

    /**
     * Utility method for running tests when we expect the date to be invalid and to throw an
     * exception.
     *
     * @param exceptionMessage The exception message we expect to have displayed.
     * @param dateString The string we are trying to parse into a date.
     */
    private void parseISO8601Date_Invalid(String exceptionMessage, String dateString) throws MeterReadsException {
        MeterReadsExceptionTestHelper.expectMessage(expectedException, exceptionMessage);
        DateTimeUtils.parseISO8601Date(dateString);
    }

}