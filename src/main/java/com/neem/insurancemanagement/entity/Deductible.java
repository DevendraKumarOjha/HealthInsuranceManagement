package com.neem.insurancemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "deductible")
@AllArgsConstructor
@NoArgsConstructor
public class Deductible {
    //Assumption some plans have default amount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deductibleId;
    //private int defaultStandardDeductibleAmount;
    //private int standardDeductibleUsedAmount;
    private String category;
    private double individualAmount;
    boolean isNonStandard;

    }
