package com.neem.insurancemanagement.repository;

import com.neem.insurancemanagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

    public List<Insurance> findAll();

    public Insurance findById(int id);
}
