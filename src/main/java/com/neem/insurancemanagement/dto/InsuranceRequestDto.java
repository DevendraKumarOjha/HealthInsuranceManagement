package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InsuranceRequestDto {
    String insurancePlanName;
    int insurancePlanNumber;
    String insuranceType;
    String insurancePlanStatus;
    String insuranceFeeScheduler;
    String insuranceNetworkStatus;
    String insurancePlanNotes;
    //LocalDate policyStartDate;
    //LocalDate policyEndDate;
}
