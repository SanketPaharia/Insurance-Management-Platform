package com.example.service;

import com.example.model.Client;
import com.example.model.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyService {

    public List<InsurancePolicy> findAllInsurancePolicies() ;
    public InsurancePolicy findById(int id) ;
    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy);
    public InsurancePolicy updateInsurancePolicy(int id , InsurancePolicy insurancePolicy);
    public String deleteInsurancePolicy(int id);



}
