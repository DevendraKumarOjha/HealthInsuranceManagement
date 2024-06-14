package com.neem.insurancemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientDeductibleNotFoundException extends RuntimeException {

    public PatientDeductibleNotFoundException(String exception) {
        super(exception);
    }
}
