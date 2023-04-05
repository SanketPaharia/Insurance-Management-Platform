package com.example.controller;


import com.example.model.Claim;
import com.example.model.InsurancePolicy;
import com.example.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InsurancePolicyController {


    @Autowired
    InsurancePolicyService insurancePolicyService ;


    @PostMapping("/claims")
    public ResponseEntity<InsurancePolicy> addPolicyHandler(@Valid @RequestBody InsurancePolicy insurancePolicy) {
        InsurancePolicy newPolicy = insurancePolicyService.createInsurancePolicy(insurancePolicy);

        return new ResponseEntity<>(newPolicy, HttpStatus.CREATED);
    }


    @GetMapping("/claims/{id}")
    public ResponseEntity<InsurancePolicy> findClaimHandler(@PathVariable Integer id){
        InsurancePolicy insurancePolicy = insurancePolicyService.findById(id);

        return new ResponseEntity<>(insurancePolicy,HttpStatus.FOUND);
    }

    @GetMapping("/claims")
    public ResponseEntity<List<InsurancePolicy>> getListOfAllClaimsHandler(){

        List<InsurancePolicy> list = insurancePolicyService.findAllInsurancePolicies();

        return new ResponseEntity<>(list ,HttpStatus.FOUND);
    }

    @PutMapping("/claims/{id}")
    public ResponseEntity<InsurancePolicy> updateClaim(@Valid  @PathVariable Integer id, @RequestBody InsurancePolicy insurancePolicy) {
       InsurancePolicy newPolicy =insurancePolicyService.updateInsurancePolicy(id , insurancePolicy);


        return new ResponseEntity<>( newPolicy,HttpStatus.OK);
    }

    @DeleteMapping("/claims/{id}")
    public ResponseEntity<String> deleteClaim(@Valid @PathVariable int id) {
        String result = insurancePolicyService.deleteInsurancePolicy(id);

        return new ResponseEntity<>(result , HttpStatus.ACCEPTED );
    }

}
