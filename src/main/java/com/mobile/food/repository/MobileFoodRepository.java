package com.mobile.food.repository;

import com.mobile.food.entity.MobileFoodFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileFoodRepository extends JpaRepository<MobileFoodFacility, Long> {

    List<MobileFoodFacility> findAllByLocationDescriptionContainingIgnoreCaseOrAddressContainingIgnoreCase(String locationDescription, String address);

    List<MobileFoodFacility> findAllByAddressContainingIgnoreCase(String address);

    List<MobileFoodFacility> findAllByFoodItemsContainingIgnoreCase(String foodItems);

    List<MobileFoodFacility> findAllByFacilityTypeContainingIgnoreCase(String address);

    List<MobileFoodFacility> findAllByApplicantContainingIgnoreCaseAndFacilityTypeContainingIgnoreCase(String applicant, String facilityType);
}
