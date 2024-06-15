package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RemainingStandardDeductibles {
    int standardAmount;
    int usedAmount;
    int remainingAmount;
}
