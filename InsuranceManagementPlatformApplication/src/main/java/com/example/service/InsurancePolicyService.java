package com.example.service;

import com.example.Dto.InsurancePolicyDto;
import com.example.model.Client;
import com.example.model.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyService {

    public List<InsurancePolicy> findAllInsurancePolicies() ;
    public InsurancePolicy findById(int id) ;
    public InsurancePolicy createInsurancePolicy(InsurancePolicyDto insurancePolicyDto);
    public InsurancePolicy updateInsurancePolicy(int id , InsurancePolicyDto insurancePolicyDto);
    public String deleteInsurancePolicy(int id);



}
