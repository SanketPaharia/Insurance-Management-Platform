package com.example.demo.service;

import com.example.demo.model.Claim;
import com.example.demo.model.InsurancePolicy;

import java.util.List;

public interface ClaimService {

    public List<Claim> findAllClaims() ;
    public Claim findClaimById() ;
    public String createClaim();
    public Claim updateClaim();
    public String deleteClaim();
}
