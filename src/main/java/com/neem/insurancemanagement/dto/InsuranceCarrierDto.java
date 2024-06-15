package com.neem.insurancemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InsuranceCarrierDto {

    String carrierName;
    String phoneNumber;
    String city;
    String state;
    String zip;
    String webSite;
}
