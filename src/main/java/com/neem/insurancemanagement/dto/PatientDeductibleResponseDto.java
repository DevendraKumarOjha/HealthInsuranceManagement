package com.neem.insurancemanagement.dto;

import com.neem.insurancemanagement.entity.Deductible;
import com.neem.insurancemanagement.entity.Patient;
import com.neem.insurancemanagement.entity.PatientDependents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDeductibleResponseDto {

    Patient patient;
    List<Deductible> deductibles;

    List<PatientDependents> patientDependents;

}
