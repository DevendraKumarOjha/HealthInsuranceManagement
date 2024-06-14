package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.neem.insurancemanagement.entity.Insurance;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientRequestDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private int age;
    private String insuranceType;
    private Insurance Insurance;
    //List<PatientDeductible> patientDeductible;

}
