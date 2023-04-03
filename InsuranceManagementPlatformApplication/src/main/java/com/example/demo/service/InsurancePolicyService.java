package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyService {

    public List<InsurancePolicy> findAllInsurancePolicies() ;
    public InsurancePolicy findById() ;
    public String createInsurancePolicy();
    public InsurancePolicy updateInsurancePolicy();
    public String deleteInsurancePolicy();
}
