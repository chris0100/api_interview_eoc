package com.mobile.food.cache;

import com.mobile.food.entity.MobileFoodFacility;
import com.mobile.food.entity.dto.MobileFoodFacilityDTO;
import com.mobile.food.repository.MobileFoodRepository;
import com.mobile.food.service.MobileFoodService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class CacheTest {

    @MockBean
    MobileFoodRepository repository;

    @Autowired
    MobileFoodService service;

    @Autowired
    ModelMapper mapper;


    @Test
    void cacheTest(){
        given(repository.findById(1575199L))
                .willReturn(Optional.of(MobileFoodFacility.builder()
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
                        .build()));

        MobileFoodFacilityDTO mobileFoodFacility = mapper.map(service.getById(1575199L), MobileFoodFacilityDTO.class);
        assertNotNull(mobileFoodFacility);

        //recall
        service.getById(1575199L);
        verify(repository, times(1)).findById(1575199L);
    }
}
