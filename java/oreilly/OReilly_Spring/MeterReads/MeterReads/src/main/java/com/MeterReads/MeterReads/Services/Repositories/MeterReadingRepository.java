package com.MeterReads.MeterReads.Services.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * This constitutes the repository for the meter readings and is our
 * method of interacting with the data storage.
 */
public interface MeterReadingRepository extends CrudRepository<MeterReading, Long> {

    /**
     * This is a custom method so we can retrieve from the database using both
     * the customer Id and the serial number in combination.
     *
     * @param customerId The customer Id we are searching for
     * @param serialNumber The serial number we are searching for
     *
     * @return All meter readings with that customer Id and serial number
     */
    List<MeterReading> findByCustomerIdAndSerialNumber(String customerId, long serialNumber);

    /**
     * This is a custom method to retrieve from the database using all of the
     * data fields
     *
     * @param customerId The customer Id we are searching for
     * @param serialNumber The serial number we are searching for
     * @param mpxn The mpxn we are searching for
     * @param readDate The read date we are searching for
     *
     * @return All meter readings with the corresponding parameter values
     */
    List<MeterReading> findByCustomerIdAndSerialNumberAndMpxnAndReadDate(String customerId, long serialNumber, long mpxn, OffsetDateTime readDate);

}
