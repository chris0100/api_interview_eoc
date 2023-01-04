package com.mobile.food.service;

import com.mobile.food.entity.MobileFoodFacility;
import com.mobile.food.entity.dto.MobileFoodFacilityDTO;

import java.util.List;

public interface MobileFoodService {
    List<MobileFoodFacilityDTO> getAll();

    List<MobileFoodFacilityDTO> getAllByLocationDescriptionOrAddress(String locationDescription);

    List<MobileFoodFacilityDTO> getAllByAddress(String address);

    List<MobileFoodFacilityDTO> getAllByFacilityType(String facilityType);

    List<MobileFoodFacilityDTO> getAllByApplicantAndFacilityType(String applicant, String facilityType);

    MobileFoodFacilityDTO getById(Long locationId);

    List<MobileFoodFacilityDTO> getCloseMobileFood(Double latitude, Double longitude);
}
