package com.example.service;

import com.example.Dto.ClaimDto;
import com.example.model.Claim;
import com.example.model.Client;

import java.util.List;

public interface ClaimService {

    public List<Claim> findAllClaims() ;
    public Claim findClaimById(int id) ;
    public Claim createClaim(ClaimDto claimDto);
    public Claim updateClaim(int id , ClaimDto claimDto);
    public String deleteClaim(int id);



}
