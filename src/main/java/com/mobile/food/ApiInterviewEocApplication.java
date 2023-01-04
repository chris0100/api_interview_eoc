package com.mobile.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiInterviewEocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiInterviewEocApplication.class, args);
    }

}
