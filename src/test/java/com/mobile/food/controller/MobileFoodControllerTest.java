package com.mobile.food.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.food.entity.dto.MobileFoodFacilityDTO;
import com.mobile.food.error.MobileFoodFacilityNotFoundException;
import com.mobile.food.service.impl.MobileFoodServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.mobile.food.DummyData.allMobileFoodFacility;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MobileFoodController.class)
@ActiveProfiles("test")
class MobileFoodControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MobileFoodServiceImpl service;

    private static final ObjectMapper om = new ObjectMapper();


    @Test
    void testGetMobileFoodById() throws Exception {
        given(service.getById(anyLong())).willReturn(allMobileFoodFacility().get(0));

        mockMvc.perform(get("/api/find-by/1575199"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("facilityType").value("Truck"));
    }


    @Test
    void testMobileFoodNotFoud() throws Exception {
        given(service.getById(anyLong())).willThrow(new MobileFoodFacilityNotFoundException("mobile food not found"));

        mockMvc.perform(get("/api/find-by/1575199"))
                .andExpect(status().isNotFound());
    }


    @Test
    void testGetAllMobileFood() throws Exception {
        given(service.getAll()).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }

    @Test
    void testGetAllMobileFoodByLocationDescriptionOrAddress() throws Exception {
        given(service.getAllByLocationDescriptionOrAddress(anyString())).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all/location-description-address/newhall"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }

    @Test
    void testGetAllMobileFoodByAddress() throws Exception {
        given(service.getAllByAddress(anyString())).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all/address/mendell"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }

    @Test
    void testGetAllMobileFoodByFoodItems() throws Exception {
        given(service.getAllByFoodItems(anyString())).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all/food-items/cheeseburgers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }

    @Test
    void testGetAllMobileFoodByFacilityType() throws Exception {
        given(service.getAllByFacilityType(anyString())).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all/facility-type/truck"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }

    @Test
    void testGetAllMobileFoodByApplicantFacilityType() throws Exception {
        given(service.getAllByApplicantAndFacilityType(anyString(), anyString())).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all/applicant/catering/facility-type/truck"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }


    @Test
    void testGetAllCloseMobilefoodByLatitudeAndLongitude() throws Exception {
        given(service.getCloseMobileFood(anyDouble(), anyDouble())).willReturn(allMobileFoodFacility());

        List<MobileFoodFacilityDTO> actualRecords = om.readValue(mockMvc.perform(get("/api/find-all/location?latitude=37.71&longitude=-122.397"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(allMobileFoodFacility().size())))
                .andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });

        validateDataInside(actualRecords);
    }


    private static void validateDataInside(List<MobileFoodFacilityDTO> actualRecords) {
        for (int i = 0; i < allMobileFoodFacility().size(); i++) {
            assertTrue(new ReflectionEquals(allMobileFoodFacility().get(i).getFoodItems()).matches(actualRecords.get(i).getFoodItems()));
            assertTrue(new ReflectionEquals(allMobileFoodFacility().get(i).getAddress()).matches(actualRecords.get(i).getAddress()));
            assertTrue(new ReflectionEquals(allMobileFoodFacility().get(i).getLocationDescription()).matches(actualRecords.get(i).getLocationDescription()));
            assertTrue(new ReflectionEquals(allMobileFoodFacility().get(i).getFoodItems()).matches(actualRecords.get(i).getFoodItems()));
            assertTrue(new ReflectionEquals(allMobileFoodFacility().get(i).getFacilityType()).matches(actualRecords.get(i).getFacilityType()));
        }
    }

}