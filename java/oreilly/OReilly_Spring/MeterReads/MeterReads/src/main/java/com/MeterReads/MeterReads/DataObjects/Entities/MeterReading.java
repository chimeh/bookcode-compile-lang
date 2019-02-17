package com.MeterReads.MeterReads.DataObjects.Entities;

import com.MeterReads.MeterReads.Utils.DateTime.DateTimeUtils;
import com.MeterReads.MeterReads.Utils.Exceptions.MeterReadsException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This object maps to the below schema and is used for ingesting
 * JSON from requests to the API and saving them to the database.
 *
 * {
 *    "customerId": "identifier123",
 *    "serialNumber": "27263927192",
 *    "mpxn": "14582749",
 *    "read": [
 *          {"type": "ANYTIME", "registerId": "387373", "value": "2729"},
 *          {"type": "NIGHT", "registerId": "387373", "value": "2892"}
 *    ],
 *    "readDate": "2017-11-20T16:19:48+00:00Z"
 * }
 *
 * Note: To connect to the H2 console we need to use jdbc:h2:mem:testdb
 */
@Data
@EqualsAndHashCode(exclude = "meterReadingId")
@Entity
@Table(name = "METER_READINGS")
public class MeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "METER_READING_ID")
    private Long meterReadingId;

    private String customerId;
    private long serialNumber;
    private long mpxn;
    private OffsetDateTime readDate;

    @OneToMany(
            targetEntity=Read.class,
            mappedBy="meterReading",
            fetch=FetchType.EAGER,
            cascade=CascadeType.ALL
    )
    private List<Read> read;

    @JsonIgnore
    public Long getMeterReadingId() {
        return meterReadingId;
    }

    @JsonIgnore
    public void setMeterReadingId(Long meterReadingId) {
        this.meterReadingId = meterReadingId;
    }

    /**
     * When we set reads within this class we also need to set the parent meter reading as this
     * meter reading.
     *
     * @param read The list of readings we are setting
     */
    public void setRead(List<Read> read) {
        for(Read individualRead: read) {
            individualRead.setMeterReading(this);
        }
        this.read = read;
    }

    /**
     * When we set the readDate we need to parse from a string provided in the JSON to an
     * OffsetDateTime we can use in the rest of the program.
     *
     * @param readDate A string of the date we would like to parse
     *
     * @throws MeterReadsException If we cannot parse the string to an OffsetDateTime
     */
    public void setReadDate(String readDate) throws MeterReadsException {
        this.readDate = DateTimeUtils.parseISO8601Date(readDate);
    }

    /**
     * When we return the read date to be used as part of the JSON we want to
     * convert it from an OffsetDateTime to a string that can be used in the
     * rest of the program.
     *
     * @return A string of the read date, correctly formatted.
     */
    public String getReadDate() {
        return DateTimeUtils.convertOffsetDateTimeToISO8601DateString(readDate);
    }

}
