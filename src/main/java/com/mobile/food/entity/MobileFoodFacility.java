package com.mobile.food.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "mobile_food_facility")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileFoodFacility {

    @Id
    @CsvBindByName(column = "locationid")
    private Long locationId;

    @Lob
    @Column
    @CsvBindByName(column = "Applicant")
    private String applicant;

    @Lob
    @Column
    @CsvBindByName(column = "FacilityType")
    private String facilityType;

    @CsvBindByName(column = "cnn")
    private Integer cnn;

    @Lob
    @Column
    @CsvBindByName(column = "LocationDescription")
    private String locationDescription;

    @Lob
    @Column
    @CsvBindByName(column = "Address")
    private String address;

    @Lob
    @Column
    @CsvBindByName(column = "blocklot")
    private String blocklot;

    @Lob
    @Column
    @CsvBindByName(column = "block")
    private String block;

    @Lob
    @Column
    @CsvBindByName(column = "lot")
    private String lot;

    @Lob
    @Column
    @CsvBindByName(column = "permit")
    private String permit;

    @Lob
    @Column
    @CsvBindByName(column = "Status")
    private String status;

    @Lob
    @Column
    @CsvBindByName(column = "FoodItems")
    private String foodItems;

    @CsvBindByName(column = "X")
    private Double xCoordinate;

    @CsvBindByName(column = "Y")
    private Double yCoordinate;

    @CsvBindByName(column = "Latitude")
    private Double latitude;

    @CsvBindByName(column = "Longitude")
    private Double longitude;

    @Lob
    @Column
    @CsvBindByName(column = "Schedule")
    private String schedule;

    @Lob
    @Column
    @CsvBindByName(column = "dayshours")
    private String dayshours;

    @Lob
    @Column
    @CsvBindByName(column = "NOISent")
    private String noiSent;

    @DateTimeFormat(pattern="MM/dd/yyyy hh:mm")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="MM/dd/yyyy hh:mm")
    @CsvDate(value = "MM/dd/yyyy HH:mm")
    @CsvBindByName(column = "Approved")
    private Date approved;

    @DateTimeFormat(pattern="yyyyMMdd")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyyMMdd")
    @CsvDate(value = "yyyyMMdd")
    @CsvBindByName(column = "Received")
     private Date received;

    @CsvBindByName(column = "PriorPermit")
    private Boolean priorPermit;

    @DateTimeFormat(pattern="MM/dd/yyyy hh:mm")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="MM/dd/yyyy hh:mm")
    @CsvDate(value = "MM/dd/yyyy HH:mm")
    @CsvBindByName(column = "ExpirationDate")
    private Date expirationDate;

    @Lob
    @Column
    @CsvBindByName(column = "Location")
    private String location;

    @CsvBindByName(column = "Fire Prevention Districts")
    private Integer firePreventionDistricts;

    @CsvBindByName(column = "Police Districts")
    private Integer policeDistricts;

    @CsvBindByName(column = "Supervisor Districts")
    private Integer supervisorDistricts;

    @Lob
    @Column
    @CsvBindByName(column = "Zip Codes")
    private String zipCodes;

    @CsvBindByName(column = "Neighborhoods (old)")
    private Integer neighborhoods;
}
