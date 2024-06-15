package com.neem.insurancemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "patient_deductible")
@AllArgsConstructor
@NoArgsConstructor
public class PatientDeductible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientDeductibleId;
    private int deductibleId;
    private int patientId;

    private int standardDeductibleAmount;
    private int standardDeductibleRemainingAmount;
    private String category;
    private double individualAmount;
    boolean isNonStandard;
}
