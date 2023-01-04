package com.mobile.food.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MobileFoodFacilityNotFoundException.class)
    public ResponseEntity<ApiError> handleException(MobileFoodFacilityNotFoundException e, HttpServletRequest request){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.toString(), e.getLocalizedMessage(), request.getServletPath());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
