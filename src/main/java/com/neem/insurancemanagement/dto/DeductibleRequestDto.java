package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeductibleRequestDto {
    private String category;
    private double individualAmount;
    //private int standardDeductibleAmount;
    //private int standardDeductibleUsedAmount;
    boolean isNonStandard;
}
