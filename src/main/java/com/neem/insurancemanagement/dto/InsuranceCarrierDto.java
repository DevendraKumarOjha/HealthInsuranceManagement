package com.neem.insurancemanagement.dto;

import com.neem.insurancemanagement.entity.Insurance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
    //List<Insurance> insurance;
}
