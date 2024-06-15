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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deductibleId;
    private String category;
    private double individualAmount;
    boolean isNonStandard;
}
