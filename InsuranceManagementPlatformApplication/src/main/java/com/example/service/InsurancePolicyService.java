package com.example.service;

import com.example.model.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyService {

    public List<InsurancePolicy> findAllInsurancePolicies() ;
    public InsurancePolicy findById() ;
    public String createInsurancePolicy();
    public InsurancePolicy updateInsurancePolicy();
    public String deleteInsurancePolicy();
}
