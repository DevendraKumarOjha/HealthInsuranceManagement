package com.neem.insurancemanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriberRequestDto {

    private int patientId;
    //private String firstName;
    //private String secondName;
    //private String insuranceType;
    //private String coverageStart;
    private double deductible;
}
