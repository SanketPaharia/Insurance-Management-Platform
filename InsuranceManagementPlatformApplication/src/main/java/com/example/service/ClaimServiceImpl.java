package com.example.service;

import com.example.Dto.ClaimDto;
import com.example.model.Client;
import com.example.model.InsurancePolicy;
import com.example.repository.ClaimDao;
import com.example.exception.ClaimException;
import com.example.model.Claim;
import com.example.repository.ClientDao;
import com.example.repository.InsurancePolicyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    ClaimDao claimDao;

    @Autowired
    InsurancePolicyDao insurancePolicyDao;

    @Autowired
    ClientDao clientDao;

    @Override
    public List<Claim> findAllClaims() {
        List<Claim> list = new ArrayList<>();
        list =  claimDao.findAll();
        if (list.size()!=0) {
            return list;
        }
        else {
            throw new ClaimException("Empty database found" );
        }
    }

    @Override
    public Claim findClaimById(int id) {
        Optional<Claim> claim = claimDao.findById(id);
        if (claim.isPresent()) {
            return claim.get();
        }
        else {
            throw new ClaimException("no claim found with id: " + id  );
        }
    }

    @Override
    public Claim createClaim( ClaimDto claimDto) {
        Claim claim = this.dtoToClaim(claimDto);

        InsurancePolicy insurancePolicy = this.insurancePolicyDao.findById(claimDto.getInsuranceId()).orElseThrow(() -> new RuntimeException("Invalid Insurance Id"));

        claim.setInsurancePolicy(insurancePolicy);
        insurancePolicy.setClaim(claim);

        Client client = this.clientDao.findById(claimDto.getClientId()).orElseThrow(() -> new RuntimeException("Invalid Client Id"));

        claim.setClient(client);

        return claimDao.save(claim);
    }

    @Override
    public Claim updateClaim(int id, ClaimDto claimDto) {
        Optional<Claim> newClaim = claimDao.findById(id);
        if (newClaim.isEmpty()) {
            throw new ClaimException("no claim found with id: " + id );
        }
        Claim existingClaim = newClaim.get();
        existingClaim.setClaimDate(claimDto.getClaimDate());
        existingClaim.setClaimNumber(claimDto.getClaimNumber());
        existingClaim.setClaimStatus(claimDto.getClaimStatus());
        existingClaim.setDescription(claimDto.getDescription());
        return claimDao.save(existingClaim);
    }

    @Override
    public String deleteClaim(int id) {
        Optional<Claim> newclaim = claimDao.findById(id);
        if (newclaim.isPresent()) {
            claimDao.deleteById(id);
            return "Claim with id: " + id + "deleted" ;
        }

        else{
            throw new ClaimException("no claim found with id: " + id );
        }
    }
    public Claim dtoToClaim(ClaimDto claimDto){
        Claim existingClaim = new Claim();

        existingClaim.setClaimDate(claimDto.getClaimDate());
        existingClaim.setClaimNumber(claimDto.getClaimNumber());
        existingClaim.setClaimStatus(claimDto.getClaimStatus());
        existingClaim.setDescription(claimDto.getDescription());

        return existingClaim;
    }
}
