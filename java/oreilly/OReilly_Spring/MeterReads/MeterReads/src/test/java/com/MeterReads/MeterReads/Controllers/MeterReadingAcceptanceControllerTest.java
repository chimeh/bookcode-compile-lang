package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Entities.Read;
import com.MeterReads.MeterReads.MeterReadsApplication;
import com.MeterReads.MeterReads.Services.Repositories.MeterReadingRepository;
import com.MeterReads.MeterReads.Utils.DateTime.DateTimeUtils;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * This class is used to test the MeterReadingAcceptanceController.
 *
 * @see MeterReadingAcceptanceController
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeterReadsApplication.class)
@WebAppConfiguration
public class MeterReadingAcceptanceControllerTest {

    /**
     * Content Type as we will be sending a JSON to the post request.
     */
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /*
        Set Up
     */

    /**
     * This is used to find the necessary converter so we can convert
     * from a Java Jackson object to a JSON.
     *
     * @param converters A list of converters
     */
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    /*
        Tests
     */

    @Test
    public void meterRead_ValidInputs_PostAndSaveReturnCorrectly() throws Exception, MeterReadsException {
        meterRead("customerId", 1, 2,"2017-11-20T16:19:48+00:00Z", "type", 3, 4);
    }

    /*
        Utilities
     */

    /**
     * This is an umbrella test for making sure that when you send a JSON to the meter reading
     * acceptance controller it saves it correctly.
     *
     * @param customerId The customer Id of the meter reading
     * @param serialNumber The serial number of the meter reading
     * @param mpxn The mpxn of the meter reading
     * @param readDate The read date of the meter reading
     * @param type The type of the meter reading read
     * @param registerId The register id of the meter reading read
     * @param value The value of the meter reading read
     *
     * @throws Exception As part of the post
     *
     * @throws MeterReadsException As part of reading the date time string
     */
    public void meterRead(String customerId, long serialNumber, long mpxn, String readDate, String type, long registerId, long value) throws Exception, MeterReadsException {

        MeterReading meterReading = createMeterReading(customerId, serialNumber, mpxn, readDate, type, registerId, value);

        mockMvc.perform(post(MeterReadingAcceptanceController.URI)
                .contentType(contentType)
                .content(this.json(meterReading)))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerId", is(meterReading.getCustomerId())))
                .andExpect(jsonPath("$.serialNumber", is(new Long(meterReading.getSerialNumber()).intValue())))
                .andExpect(jsonPath("$.mpxn", is(new Long(meterReading.getMpxn()).intValue())))
                .andExpect(jsonPath("$.readDate", is(meterReading.getReadDate())))
                .andExpect(jsonPath("$.read", hasSize(1)))
                .andExpect(jsonPath("$.read[0].type", is(meterReading.getRead().get(0).getType())))
                .andExpect(jsonPath("$.read[0].registerId", is(new Long(meterReading.getRead().get(0).getRegisterId()).intValue())))
                .andExpect(jsonPath("$.read[0].value", is(new Long(meterReading.getRead().get(0).getValue()).intValue())))
        ;

        List<MeterReading> meterReadingSaved = meterReadingRepository.findByCustomerIdAndSerialNumberAndMpxnAndReadDate(
                customerId,
                serialNumber,
                mpxn,
                DateTimeUtils.parseISO8601Date(readDate)
        );

        assertMeterReadingsEqual(meterReading, meterReadingSaved);

    }

    /*
        Utilities
     */

    /**
     * This creates a new meter reading from all of the given inputs.
     *
     * @param customerId The customer Id of the meter reading
     * @param serialNumber The serial number of the meter reading
     * @param mpxn The mpxn of the meter reading
     * @param readDate The read date of the meter reading
     * @param type The type of the meter reading read
     * @param registerId The register id of the meter reading read
     * @param value The value of the meter reading read
     *
     * @return A brand new meter reading with these fields
     *
     * @throws MeterReadsException From the parsing of the read date string
     */
    private MeterReading createMeterReading(String customerId, long serialNumber, long mpxn, String readDate, String type, long registerId, long value) throws MeterReadsException {

        MeterReading meterReading = new MeterReading();
        Read read = new Read();

        meterReading.setCustomerId(customerId);
        meterReading.setSerialNumber(serialNumber);
        meterReading.setMpxn(mpxn);
        meterReading.setReadDate(readDate);

        read.setType(type);
        read.setRegisterId(registerId);
        read.setValue(value);

        meterReading.setRead(new ArrayList<>(Collections.singletonList(read)));

        return meterReading;

    }

    /**
     * We need to do this as one is incoming and has no Id and one has been saved to
     * the database so has an Id. We also need to make sure the implementation of List
     * they both use is comparable.
     *
     * @param createdMeterReading The meter reading we created.
     * @param savedMeterReading The meter reading taken from the database.
     */
    private void alterMeterReadsForComparison(MeterReading createdMeterReading, MeterReading savedMeterReading) {

        createdMeterReading.setMeterReadingId(null);
        createdMeterReading.getRead().get(0).setReadId(null);

        savedMeterReading.setMeterReadingId(null);
        savedMeterReading.getRead().get(0).setReadId(null);

        savedMeterReading.setRead(Arrays.asList(savedMeterReading.getRead().toArray(new Read[0])));

    }

    /**
     * This is used to check we only have one database saved to the database and that
     * it matches what we posted to the API
     *
     * @param createdMeterReading The meter reading we created.
     * @param savedMeterReadings The meter readings taken from the database.
     */
    private void assertMeterReadingsEqual(MeterReading createdMeterReading, List<MeterReading> savedMeterReadings) {

        assertThat(savedMeterReadings.size(), is(1));
        assertThat(savedMeterReadings.get(0).getRead().size(), is(1));

        alterMeterReadsForComparison(createdMeterReading, savedMeterReadings.get(0));

        assertThat(savedMeterReadings.get(0).equals(createdMeterReading), is(true));

    }

    /**
     * This is a wrapper function for writing an object to JSON
     *
     * @param o The object to be written
     *
     * @return A JSON String of the object
     *
     * @throws IOException Thrown if we cannot write to JSON
     */
    private String json(Object o) throws IOException {

        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();

    }

}