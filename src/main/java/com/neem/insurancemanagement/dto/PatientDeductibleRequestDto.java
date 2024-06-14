package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDeductibleRequestDto {
    //private String deductibleCategory;
    private int patientId;
    private int deductibleId;
    private int standardDeductibleAmount;
    private int standardDeductibleUsedAmount;
    private String category;
    private double individualAmount;
    boolean isNonStandard;

}
