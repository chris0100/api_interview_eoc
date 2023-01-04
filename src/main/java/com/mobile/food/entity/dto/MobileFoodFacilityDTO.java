package com.mobile.food.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MobileFoodFacilityDTO {

    private Long locationId;
    private String applicant;
    private String facilityType;
    private Integer cnn;
    private String locationDescription;
    private String address;
    private String blocklot;
    private String block;
    private String lot;
    private String permit;
    private String status;
    private String foodItems;
    private Double xCoordinate;
    private Double yCoordinate;
    private Double latitude;
    private Double longitude;
    private String schedule;
    private String dayshours;
    private String noiSent;
    private Date approved;
    private Date received;
    private Boolean priorPermit;
    private Date expirationDate;
    private String location;
    private Integer firePreventionDistricts;
    private Integer policeDistricts;
    private Integer supervisorDistricts;
    private String zipCodes;
    private Integer neighborhoods;
}
