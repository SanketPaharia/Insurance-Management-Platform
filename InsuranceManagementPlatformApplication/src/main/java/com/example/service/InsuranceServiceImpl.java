package com.example.service;

import com.example.Dto.InsurancePolicyDto;
import com.example.exception.ClaimException;
import com.example.exception.InsuranceException;
import com.example.model.Claim;
import com.example.model.InsurancePolicy;
import com.example.repository.InsurancePolicyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsurancePolicyService{

    @Autowired
    InsurancePolicyDao insurancePolicyDao ;

    @Override
    public List<InsurancePolicy> findAllInsurancePolicies() {
        List<InsurancePolicy> list = new ArrayList<>();

        list =  insurancePolicyDao.findAll();

        if (list.size()!=0) {

            return list ;
        }

        else {
            throw new InsuranceException("Empty database found" );
        }    }

    @Override
    public InsurancePolicy findById(int id) {
        Optional<InsurancePolicy> insurancePolicy = insurancePolicyDao.findById(id);

        if (insurancePolicy.isPresent()) {

            return insurancePolicy.get();
        }

        else {
            throw new InsuranceException("no policy found with id: " + id  );
        }
    }

    @Override
    public InsurancePolicy createInsurancePolicy(InsurancePolicyDto insurancePolicyDto) {
        return insurancePolicyDao.save(this.dtoToPolicy(insurancePolicyDto));
    }

    @Override
    public InsurancePolicy updateInsurancePolicy(int id, InsurancePolicyDto insurancePolicyDto) {
        Optional<InsurancePolicy> newPolicy = insurancePolicyDao.findById(id);

        if (newPolicy.isEmpty()) {
            return insurancePolicyDao.save(this.dtoToPolicy(insurancePolicyDto));
        }

        InsurancePolicy existingPolicy = newPolicy.get();

        existingPolicy.setPolicyNumber(insurancePolicyDto.getPolicyNumber());
        existingPolicy.setCoverageAmount(insurancePolicyDto.getCoverageAmount());
        existingPolicy.setEndDate(insurancePolicyDto.getEndDate());
        existingPolicy.setStartDate(insurancePolicyDto.getStartDate());
        existingPolicy.setPremium(insurancePolicyDto.getPremium());
        existingPolicy.setType(insurancePolicyDto.getType());

        return insurancePolicyDao.save(existingPolicy);
    }

    @Override
    public String deleteInsurancePolicy(int id) {
        Optional<InsurancePolicy> newPolicy = insurancePolicyDao.findById(id);

        if (newPolicy.isPresent()) {

          insurancePolicyDao.deleteById(id);
          return "Policy with id: " + id + "deleted" ;
        }

        else{
            throw new InsuranceException("no claim found with provided id");

        }
    }

    public InsurancePolicy dtoToPolicy(InsurancePolicyDto insurancePolicyDto){
        InsurancePolicy existingPolicy = new InsurancePolicy();

        existingPolicy.setPolicyNumber(insurancePolicyDto.getPolicyNumber());
        existingPolicy.setCoverageAmount(insurancePolicyDto.getCoverageAmount());
        existingPolicy.setEndDate(insurancePolicyDto.getEndDate());
        existingPolicy.setStartDate(insurancePolicyDto.getStartDate());
        existingPolicy.setPremium(insurancePolicyDto.getPremium());
        existingPolicy.setType(insurancePolicyDto.getType());

        return existingPolicy;
    }
}
