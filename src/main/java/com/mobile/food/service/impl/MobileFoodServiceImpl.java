package com.mobile.food.service.impl;

import com.mobile.food.entity.MobileFoodFacility;
import com.mobile.food.entity.dto.MobileFoodFacilityDTO;
import com.mobile.food.error.MobileFoodFacilityNotFoundException;
import com.mobile.food.repository.MobileFoodRepository;
import com.mobile.food.service.MobileFoodService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MobileFoodServiceImpl implements MobileFoodService {

    @Autowired
    private MobileFoodRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Cacheable("mobile_food_facility")
    @Override
    public List<MobileFoodFacilityDTO> getAll() throws MobileFoodFacilityNotFoundException {
        return repository.findAll()
                .stream()
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MobileFoodFacilityDTO> getAllByLocationDescriptionOrAddress(String search) throws MobileFoodFacilityNotFoundException {
        return repository.findAllByLocationDescriptionContainingIgnoreCaseOrAddressContainingIgnoreCase(search, search)
                .stream()
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MobileFoodFacilityDTO> getAllByAddress(String address) throws MobileFoodFacilityNotFoundException {
        return repository.findAllByAddressContainingIgnoreCase(address)
                .stream()
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MobileFoodFacilityDTO> getAllByFacilityType(String facilityType) throws MobileFoodFacilityNotFoundException {
        return repository.findAllByFacilityTypeContainingIgnoreCase(facilityType)
                .stream()
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MobileFoodFacilityDTO> getAllByApplicantAndFacilityType(String applicant, String facilityType) throws MobileFoodFacilityNotFoundException {
        return repository.findAllByApplicantContainingIgnoreCaseAndFacilityTypeContainingIgnoreCase(applicant, facilityType)
                .stream()
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    @Cacheable("mobile_food_facility")
    @Override
    public MobileFoodFacilityDTO getById(Long locationId) {
        return mapper.map(repository.findById(locationId)
                .orElseThrow(() -> new MobileFoodFacilityNotFoundException("LocationId not found: " + locationId)), MobileFoodFacilityDTO.class);

    }

    @Override
    public List<MobileFoodFacilityDTO> getCloseMobileFood(Double latitude, Double longitude) {
        return repository.findAll()
                .stream()
                .filter(mobileFoodFacility -> calculateCloseLocation(latitude, longitude, mobileFoodFacility))
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MobileFoodFacilityDTO> getAllByFoodItems(String foodItems) {
        return repository.findAllByFoodItemsContainingIgnoreCase(foodItems)
                .stream()
                .map(obj -> mapper.map(obj, MobileFoodFacilityDTO.class))
                .collect(Collectors.toList());
    }

    private boolean calculateCloseLocation(Double latitude, Double longitude, MobileFoodFacility mobileFoodFacility) {
        return Math.abs(Math.abs(mobileFoodFacility.getLatitude()) - Math.abs(latitude)) <= 0.02
                && Math.abs(Math.abs(mobileFoodFacility.getLongitude()) - Math.abs(longitude)) <= 0.02;
    }
}
