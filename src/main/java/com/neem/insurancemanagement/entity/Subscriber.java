package com.neem.insurancemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Subscriber")
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriberId;
    private int patientId;
    private int dependentId;
    private String firstName;
    private String secondName;
    private double deductible;
    private boolean isSubscriber;



}
