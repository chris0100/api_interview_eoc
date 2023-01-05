package com.mobile.food;

import com.mobile.food.entity.dto.MobileFoodFacilityDTO;
import com.mobile.food.error.ApiError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    void getMobileFoodById(){
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<MobileFoodFacilityDTO> response = restTemplate.exchange(
                "/api/find-by/1575199", HttpMethod.GET, entity, MobileFoodFacilityDTO.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("300 NEWHALL ST", Objects.requireNonNull(response.getBody()).getAddress());
    }

    @Test
    void getAllMobileFood(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(482, mobileFoodFacilityDTOList.size());
    }

    @Test
    void getAllMobileFoodByLocationDescriptionOrAddress(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all/location-description-address/1455 MARKET", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(1, mobileFoodFacilityDTOList.size());
    }

    @Test
    void getAllMobileFoodByAddress(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all/address/10th", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(3, mobileFoodFacilityDTOList.size());
    }

    @Test
    void getAllMobileFoodByFoodItems(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all/food-items/chicken", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(60, mobileFoodFacilityDTOList.size());
    }

    @Test
    void getAllMobileFoodByFacilityType(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all/facility-type/truck", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(420, mobileFoodFacilityDTOList.size());
    }

    @Test
    void getAllMobileFoodByApplicantAndFacilityType(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all/applicant/park/facility-type/truck", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(23, mobileFoodFacilityDTOList.size());
    }

    @Test
    void getAllMobileFoodByLatitudeAndLongitude(){
        ResponseEntity<List<MobileFoodFacilityDTO>> response = restTemplate.exchange(
                "/api/find-all?latitude=37.71&longitude=-122.397", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                }
        );
        List<MobileFoodFacilityDTO> mobileFoodFacilityDTOList = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assert mobileFoodFacilityDTOList != null;
        assertEquals(58, mobileFoodFacilityDTOList.size());
    }


    @Test
    void MobileFoodNotFound(){
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<ApiError> response = restTemplate.exchange(
                "/api/find-by/10", HttpMethod.GET, entity, ApiError.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


    @Test
    void main(){
        ApiInterviewEocApplication.main(new String[] {});
    }
}
