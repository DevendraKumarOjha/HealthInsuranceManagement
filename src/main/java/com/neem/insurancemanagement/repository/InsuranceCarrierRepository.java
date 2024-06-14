package com.neem.insurancemanagement.repository;

import com.neem.insurancemanagement.entity.InsuranceCarrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceCarrierRepository extends JpaRepository<InsuranceCarrier,Integer> {
    public List<InsuranceCarrier> findAll();

    public InsuranceCarrier findById(int id);

}
