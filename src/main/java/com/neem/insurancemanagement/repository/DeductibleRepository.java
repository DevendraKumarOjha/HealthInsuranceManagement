package com.neem.insurancemanagement.repository;

import com.neem.insurancemanagement.entity.Deductible;
import com.neem.insurancemanagement.entity.PatientDeductible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductibleRepository extends JpaRepository<Deductible, Integer> {

    @Query("select d from Deductible d where d.category = ?1")
    public Deductible findByCategory(String categoryName);

    @Query("select d from PatientDeductible d where d.patientId = ?1 AND d.deductibleId=?2")
    public PatientDeductible findByDeductibleIdAndPatientId(int patientId, int deductibleId);


}
