package com.example.service;

import com.example.model.Claim;

import java.util.List;

public interface ClaimService {

    public List<Claim> findAllClaims() ;
    public Claim findClaimById() ;
    public String createClaim();
    public Claim updateClaim();
    public String deleteClaim();

}
