package com.MeterReads.MeterReads.Utils.Parsing;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsExceptionTestHelper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This contains all of the tests for parsing strings to various forms.
 *
 * @see StringParser
 */
public class StringParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseLong_ValidLong_ParsesCorrectly() throws MeterReadsException {
        StringParser.parseLong("1");
    }

    @Test
    public void parseLong_String_ParsesIncorrectly() throws MeterReadsException {
        MeterReadsExceptionTestHelper.expectMessage(expectedException, StringParser.EXCEPTION_SUFFIX);
        StringParser.parseLong("Hello");
    }

}