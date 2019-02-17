package com.MeterReads.MeterReads.Services.Repositories;

import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.DataObjects.Entities.Read;
import com.MeterReads.MeterReads.Utils.DateTime.DateTimeUtils;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * This is used to test the MeterReading repository saves and finds data as
 * expected.
 *
 * @see MeterReadingRepository
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class MeterReadingRepositoryTest {

    @Autowired
    private MeterReadingRepository meterReadingRepository;
    
    @Test
    public void saveAndFindMeterReading_ValidMeterReading_ReturnsCorrectly() throws MeterReadsException {
        saveAndFindMeterReadingByAllFields("Customer Id", 1l, 1l, "2017-11-20T16:19:48+00:00Z", 1l, "Type", 1l);
    }

    @Test
    public void saveAndFindMeterReadingByCustomerIdAndSerialNumber_ValidCustomerIdAndSerialNumber_ReturnsCorrectly() throws MeterReadsException {
        saveAndFindMeterReadingByCustomerIdAndSerialNumber("Customer Id", 1l, 1l, "2017-11-20T16:19:48+00:00Z", 1l, "Type", 1l);
    }

    /*
        Utilities
     */

    /**
     * This is a function that creates a meter reading with the supplied information.
     *
     * @param customerId The customer Id we want to insert in the meter reading.
     * @param serialNumber The serial number we want to insert in the meter reading.
     * @param mpxn The mpxn we want to insert in the meter reading.
     * @param readDate The read date we want to insert in the meter reading.
     * @param registerId The register Id we want to insert in the meter reading.
     * @param type The type we want to insert in the meter reading.
     * @param value The value we want to insert in the meter reading.
     *
     * @return A newly created MeterReading
     *
     * @throws MeterReadsException This is thrown if we cannot parse the read date.
     */
    public MeterReading createMeterReading(String customerId, long serialNumber, long mpxn, String readDate, long registerId, String type, Long value) throws MeterReadsException {

        MeterReading meterReading = new MeterReading();

        meterReading.setCustomerId(customerId);
        meterReading.setMeterReadingId(serialNumber);
        meterReading.setMpxn(mpxn);
        meterReading.setReadDate(readDate);
        meterReading.setSerialNumber(serialNumber);

        Read read = new Read();
        read.setMeterReading(meterReading);
        read.setRegisterId(registerId);
        read.setType(type);
        read.setValue(value);

        meterReading.setRead(Collections.singletonList(read));

        return meterReading;
    }

    private void saveAndFindMeterReadingByAllFields(String customerId, long serialNumber, long mpxn, String readDate, long registerId, String type, Long value) throws MeterReadsException {
        saveAndFindMeterReading(customerId, serialNumber, mpxn, readDate, registerId, type, value, this::findByCustomerIdAndSerialNumberAndMpxnAndReadDate);
    }

    private void saveAndFindMeterReadingByCustomerIdAndSerialNumber(String customerId, long serialNumber, long mpxn, String readDate, long registerId, String type, Long value) throws MeterReadsException {
        saveAndFindMeterReading(customerId, serialNumber, mpxn, readDate, registerId, type, value, this::findByCustomerIdAndSerialNumber);
    }

    /**
     * This function is used to save and then find a meter reading according to a
     * set of parameters which cover what we want to save in the meter reading as
     * well as the find by function we want to execute.
     *
     * @param customerId The customer Id we want to insert in the meter reading.
     * @param serialNumber The serial number we want to insert in the meter reading.
     * @param mpxn The mpxn we want to insert in the meter reading.
     * @param readDate The read date we want to insert in the meter reading.
     * @param registerId The register Id we want to insert in the meter reading.
     * @param type The type we want to insert in the meter reading.
     * @param value The value we want to insert in the meter reading.
     * @param findByFunction The find function we want to execute to retrieve a result.
     *
     * @throws MeterReadsException
     */
    private void saveAndFindMeterReading(String customerId, long serialNumber, long mpxn, String readDate, long registerId, String type, Long value, FindByFunction findByFunction) throws MeterReadsException {

        // Arrange
        MeterReading meterReading = createMeterReading(customerId, serialNumber, mpxn, readDate, registerId, type, value);

        // Act
        MeterReading meterReadingSaved = meterReadingRepository.save(meterReading);
        List<MeterReading> savedReading = findByFunction.apply(customerId, serialNumber, mpxn, DateTimeUtils.parseISO8601Date(readDate), registerId, type, value);

        // Assert
        assertTrue(savedReading.size() == 1);
        assertThat(savedReading.get(0).equals(meterReadingSaved), is(true));
        assertThat(savedReading.get(0).getRead().equals(meterReadingSaved.getRead()), is(true));
    }

    /**
     * This defines a functional interface that can be used to execute the different
     * find by functions in the repository.
     */
    @FunctionalInterface
    private interface FindByFunction {
        List<MeterReading> apply(String customerId, long serialNumber, long mpxn, OffsetDateTime readDate, long registerId, String type, Long value);
    }

    private List<MeterReading> findByCustomerIdAndSerialNumber(String customerId, long serialNumber, long mpxn, OffsetDateTime readDate, long registerId, String type, Long value) {
        return meterReadingRepository.findByCustomerIdAndSerialNumber(customerId, serialNumber);
    }

    private List<MeterReading> findByCustomerIdAndSerialNumberAndMpxnAndReadDate(String customerId, long serialNumber, long mpxn, OffsetDateTime readDate, long registerId, String type, Long value) {
        return meterReadingRepository.findByCustomerIdAndSerialNumberAndMpxnAndReadDate(customerId, serialNumber, mpxn, readDate);
    }

}