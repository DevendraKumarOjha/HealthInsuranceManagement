package com.neem.insurancemanagement.repository;

import com.neem.insurancemanagement.entity.PatientDeductible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDeductibleRepository extends JpaRepository<PatientDeductible, Integer> {

    public List<PatientDeductible> findAll();

    public PatientDeductible findById(int id);

    @Query("select pd from PatientDeductible pd where pd.patientId = ?1")
    public List<PatientDeductible> getDeductibleByPatientId(int patientId);

    @Query("select d from PatientDeductible d where d.patientId = ?1 AND d.deductibleId=?2")
    public PatientDeductible findByDeductibleIdAndPatientId(int patientId, int deductibleId);

    @Query("select d from PatientDeductible d where d.category = ?1")
    PatientDeductible findDeductiblesByCategory(String category);
}
