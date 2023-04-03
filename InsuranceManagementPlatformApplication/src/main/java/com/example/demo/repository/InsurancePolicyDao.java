package com.example.demo.repository;

import com.example.demo.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyDao extends JpaRepository<InsurancePolicy , Integer> {


}
