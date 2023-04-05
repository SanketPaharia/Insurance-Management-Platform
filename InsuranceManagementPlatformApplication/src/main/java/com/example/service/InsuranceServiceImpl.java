package com.example.service;

import com.example.model.InsurancePolicy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsurancePolicyService{

    @Override
    public List<InsurancePolicy> findAllInsurancePolicies() {
        return null;
    }

    @Override
    public InsurancePolicy findById(int id) {
        return null;
    }

    @Override
    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
        return null;
    }

    @Override
    public InsurancePolicy updateInsurancePolicy(int id, InsurancePolicy insurancePolicy) {
        return null;
    }

    @Override
    public String deleteInsurancePolicy(int id) {
        return null;
    }
}
