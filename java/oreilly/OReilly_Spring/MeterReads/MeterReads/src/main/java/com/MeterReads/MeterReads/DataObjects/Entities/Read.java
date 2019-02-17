package com.MeterReads.MeterReads.DataObjects.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * This is the nested Read object in the schema and is
 * contained in the larger MeterReading class.
 */
@Data
@EqualsAndHashCode(exclude = {"readId", "meterReading"})
@ToString(exclude = "meterReading")
@Entity
@Table(name = "READS")
public class Read {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="METER_READING_ID")
    private MeterReading meterReading;

    private String type;
    private long registerId;
    private long value;

    @JsonIgnore
    public Long getReadId() {
        return readId;
    }

    @JsonIgnore
    public void setReadId(Long readId) {
        this.readId = readId;
    }

    @JsonIgnore
    public MeterReading getMeterReading() {
        return meterReading;
    }

    @JsonIgnore
    public void setMeterReading(MeterReading meterReading) {
        this.meterReading = meterReading;
    }
}
