package com.mobile.food;

import com.mobile.food.entity.dto.MobileFoodFacilityDTO;

import java.util.Collections;
import java.util.List;

public class DummyData {

    public static List<MobileFoodFacilityDTO> allMobileFoodFacility(){
        return Collections.singletonList(MobileFoodFacilityDTO.builder()
                .locationId(1575199L)
                .applicant("Park's Catering")
                .facilityType("Truck")
                .cnn(9563000)
                .locationDescription("NEWHALL ST: MENDELL ST to EVANS AVE (200 - 399)")
                .address("300 NEWHALL ST")
                .block("5203")
                .lot("041")
                .permit("21MFF-00115")
                .foodItems("Cold Truck: Hamburger: cheeseburgers: hot dogs: hot sandwiches: cold sandwiches: egg muffins: cup of noodles: corn dogs: canned soup: coffee: hot cocoa: hot tea: gatorade: juice: milk: soda: water: fruits: fruit salad: rice pudding: yogurt: candy bars: chips: cookies: donuts: granola bars: muffins")
                .latitude(37.74322468386162)
                .longitude(-122.38534297342117)
                .build());
    }
}
