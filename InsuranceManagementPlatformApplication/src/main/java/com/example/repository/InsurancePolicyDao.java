package com.example.repository;

import com.example.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyDao extends JpaRepository<InsurancePolicy , Integer> {


}
