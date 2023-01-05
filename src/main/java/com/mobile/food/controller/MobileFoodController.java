package com.mobile.food.controller;

import com.mobile.food.entity.dto.MobileFoodFacilityDTO;
import com.mobile.food.service.MobileFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MobileFoodController {

    @Autowired
    private MobileFoodService service;

    @GetMapping(path = "/find-by/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MobileFoodFacilityDTO> getMobilefoodByLocationId(@PathVariable Long locationId){
        return new ResponseEntity<>(service.getById(locationId), HttpStatus.OK);
    }


    @GetMapping(path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllMobilefood(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping(path = "/find-all/location-description-address/{search}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllMobilefoodByLocationDescriptionOrAddress(@PathVariable String search){
        return new ResponseEntity<>(service.getAllByLocationDescriptionOrAddress(search), HttpStatus.OK);
    }


    @GetMapping(path = "/find-all/address/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllMobilefoodByAddress(@PathVariable String address){
        return new ResponseEntity<>(service.getAllByAddress(address), HttpStatus.OK);
    }

    @GetMapping(path = "/find-all/food-items/{foodItems}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllMobilefoodByFoodItems(@PathVariable String foodItems){
        return new ResponseEntity<>(service.getAllByFoodItems(foodItems), HttpStatus.OK);
    }


    @GetMapping(path = "/find-all/facility-type/{facilityType}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllMobilefoodByFacilityType(@PathVariable String facilityType){
        return new ResponseEntity<>(service.getAllByFacilityType(facilityType), HttpStatus.OK);
    }

    @GetMapping(path = "/find-all/applicant/{applicant}/facility-type/{facilityType}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllMobilefoodByApplicantAndFacilityType(@PathVariable String applicant, @PathVariable String facilityType){
        return new ResponseEntity<>(service.getAllByApplicantAndFacilityType(applicant, facilityType), HttpStatus.OK);
    }


    @GetMapping(path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE, params = {"latitude", "longitude"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileFoodFacilityDTO>> getAllCloseMobilefoodByLatitudeAndLongitude(@RequestParam Double latitude, @RequestParam Double longitude){
        return new ResponseEntity<>(service.getCloseMobileFood(latitude, longitude), HttpStatus.OK);
    }
}
