package com.neem.insurancemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Insurance")
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int insuranceId;
    String insurancePlanName;
    int insurancePlanNumber;
    String insuranceType;
    String insurancePlanStatus;
    String insuranceFeeScheduler;
    String insuranceNetworkStatus;
    String insurancePlanNotes;

    //long price;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //Date policyStartDate;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //Date policyEndDate;
}
