package com.neem.insurancemanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@Table(name = "dependent_member")
@AllArgsConstructor
@NoArgsConstructor
public class PatientDependents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dependentId;
    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private int age;

    @JoinColumn(name="Id")
    private int patientId;

}
