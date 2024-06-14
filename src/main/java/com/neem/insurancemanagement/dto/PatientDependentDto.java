package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDependentDto {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private int age;
    private int patientId;
}
