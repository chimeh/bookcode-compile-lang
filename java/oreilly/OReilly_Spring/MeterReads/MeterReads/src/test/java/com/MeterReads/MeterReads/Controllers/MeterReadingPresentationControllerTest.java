package com.MeterReads.MeterReads.Controllers;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Entities.Read;
import com.MeterReads.MeterReads.MeterReadsApplication;
import com.MeterReads.MeterReads.Services.Repositories.MeterReadingRepository;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * This class is used to test the MeterReadingPresentationController.
 *
 * @see MeterReadingPresentationController
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MeterReadsApplication.class)
@WebAppConfiguration
public class MeterReadingPresentationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.meterReadingRepository.deleteAll();
    }

    @Test
    public void meterRead_ValidRequestNoData_ExecutesReturnsNoData() throws Exception {
        mockMvc.perform(get(MeterReadingPresentationController.URI)
                    .param("customerId", "customerId")
                    .param("serialNumber", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void meterRead_ValidRequestData_ExecutesReturnsCorrectData() throws Exception, MeterReadsException {
        meterRead("customerId", 1, 1);
    }

    /*
    Utilities
     */

    /**
     * This creates a meter read, saves it to the database and then forms a get request
     * to the URI to make sure that what is returned is what we saved to the database.
     *
     * @param customerId The customer Id of the meter reading to save.
     * @param serialNumber The serial number of the meter reading to save.
     * @param registerId The register Id of the meter reading to save.
     *
     * @throws Exception From the post request
     * @throws MeterReadsException When we try and parse the date string
     */
    private void meterRead(String customerId, long serialNumber, long registerId) throws Exception, MeterReadsException {

        MeterReading meterReading = createMeterReading(customerId, serialNumber, registerId);

        MeterReading savedMeterReading = meterReadingRepository.save(meterReading);

        mockMvc.perform(get(MeterReadingPresentationController.URI)
                .param("customerId", customerId)
                .param("serialNumber", Long.toString(serialNumber))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].customerId", is(savedMeterReading.getCustomerId())))
                .andExpect(jsonPath("$[0].serialNumber", is(new Long(savedMeterReading.getSerialNumber()).intValue())))
                .andExpect(jsonPath("$[0].read", hasSize(1)))
                .andExpect(jsonPath("$[0].read[0].registerId", is(new Long(savedMeterReading.getRead().get(0).getRegisterId()).intValue())));


    }

    /**
     * This is used to create a meter reading from the supplied information
     *
     * @param customerId The customer Id of the meter reading to save.
     * @param serialNumber The serial number of the meter reading to save.
     * @param registerId The register Id of the meter reading to save.
     *
     * @return A newly created meter reading with the supplied information.
     *
     * @throws Exception From the post request
     * @throws MeterReadsException When we try and parse the date string
     */
    private MeterReading createMeterReading(String customerId, long serialNumber, long registerId) throws Exception, MeterReadsException {

        MeterReading meterReading = new MeterReading();
        Read read = new Read();

        read.setRegisterId(registerId);

        meterReading.setCustomerId(customerId);
        meterReading.setSerialNumber(serialNumber);
        meterReading.setReadDate("2017-11-20T16:19:48+00:00Z");
        meterReading.setRead(Collections.singletonList(read));

        return meterReading;

    }

}