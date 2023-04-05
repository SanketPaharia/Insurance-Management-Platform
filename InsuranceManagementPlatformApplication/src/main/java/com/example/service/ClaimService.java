package com.example.service;

import com.example.model.Claim;
import com.example.model.Client;

import java.util.List;

public interface ClaimService {

    public List<Claim> findAllClaims() ;
    public Claim findClaimById(int id) ;
    public Claim createClaim(Claim claim);
    public Claim updateClaim(int id , Claim claim);
    public String deleteClaim(int id);



}
