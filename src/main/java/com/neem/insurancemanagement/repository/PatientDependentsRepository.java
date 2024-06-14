package com.neem.insurancemanagement.repository;

import com.neem.insurancemanagement.entity.PatientDependents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientDependentsRepository extends JpaRepository<PatientDependents, Integer> {

    public List<PatientDependents> findAll();

    @Query("select pd from PatientDependents pd where pd.patientId = ?1")
    List<PatientDependents> getAllDependents(int patientId);

    public PatientDependents findByDependentId(int id);

}
