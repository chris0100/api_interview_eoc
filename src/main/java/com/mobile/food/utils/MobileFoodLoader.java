package com.mobile.food.utils;

import com.mobile.food.entity.MobileFoodFacility;
import com.mobile.food.repository.MobileFoodRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class MobileFoodLoader implements InitializingBean {

    @Value("classpath:data/Mobile_Food_Facility_Permit.csv")
    private Resource mobileFoodFacility;

    @Autowired
    private MobileFoodRepository repository;


    @Override
    public void afterPropertiesSet() throws Exception {
        repository.saveAll(new CsvToBeanBuilder(new BufferedReader(new InputStreamReader(mobileFoodFacility.getInputStream())))
                .withType(MobileFoodFacility.class)
                .build()
                .parse());
    }
}
