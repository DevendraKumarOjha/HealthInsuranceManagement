package com.neem.insurancemanagement.repository;

import com.neem.insurancemanagement.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    List<Subscriber> findByDeductible(double deductible);
}
