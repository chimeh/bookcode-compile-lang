package com.MeterReads.MeterReads.Controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.MeterReads.MeterReads.DataObjects.Entities.MeterReading;
import com.MeterReads.MeterReads.Services.Repositories.MeterReadingRepository;
import io.swagger.annotations.ApiOperation;

/**
 * This is the controller for accepting new meter readings. It can be accessed via a POST request to the /meter-read
 * URI. It parses the body as JSON directly into a MeterReading object and returns a new MeterReadingAcceptance object
 * which will indicate the success of the request.
 */
@RestController
public class MeterReadingAcceptanceController {

    /**
     * The URI where we will access the meter reading.
     */
    protected static final String URI = "/meter-read";

    /**
     * The repository we will use to access data from the database.
     */
    @Autowired
    private MeterReadingRepository meterReadingRepository;

    /**
     * This method contains the mapping for the POST to meter-read. It parses the request body as a JSON of the
     * incoming meter reading and passes it to a new MeterReadingAcceptance object to ingest and return a success
     * code.
     *
     * @param meterReading The JSON of the body of the POST request
     *
     * @return A MeterReadingAcceptance object indicating if ingestion was successful
     */
    @ApiOperation(
            httpMethod = "POST",
            value = "Post new meter reading to API",
            notes = "New meter reading must be a valid JSON in body of request",
            response = ResponseEntity.class
    )
    @RequestMapping(value = URI, method = POST)
    public ResponseEntity<MeterReading> meterRead(@RequestBody MeterReading meterReading) {
        MeterReading meterReadingSaved = meterReadingRepository.save(meterReading);
        return new ResponseEntity<>(meterReadingSaved, HttpStatus.CREATED);
    }

}
