package com.neem.insurancemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Patient")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String insuranceType;
    private String gender;
    private int age;

    @OneToMany(mappedBy = "dependentId")
    private List<PatientDependents> dependentMember;

    @OneToOne
    @JoinColumn(name = "insuranceId")
    Insurance insurances;

    //@OneToMany(mappedBy = "deductibleId" )
    //List<PatientDeductible> patientDeductible;
}
