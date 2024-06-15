package com.neem.insurancemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "insurance_carrier")
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCarrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String carrierName;
    String phoneNumber;
    String city;
    String state;
    String zip;
    String webSite;
/*    @OneToMany(fetch = FetchType.LAZY)
    List<Insurance> insurance;*/
}
