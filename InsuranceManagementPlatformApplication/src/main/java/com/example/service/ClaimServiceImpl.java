package com.example.service;

import com.example.controller.repository.ClaimDao;
import com.example.exception.ClaimException;
import com.example.exception.ClientException;
import com.example.model.Claim;
import com.example.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    ClaimDao claimDao;

    @Override
    public List<Claim> findAllClaims() {
        List<Claim> list = new ArrayList<>();

        list =  claimDao.findAll();

        if (list.size()!=0) {

            return list ;
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
    public Claim createClaim(Claim claim) {
        Optional<Claim> newclaim = claimDao.findById(claim.getId());

        if (newclaim.isEmpty()) {

            return claimDao.save(claim);
        }

        else{
            throw new ClaimException("Claim already registered");

        }
    }

    @Override
    public Claim updateClaim(int id, Claim claim) {
        Optional<Claim> newClaim = claimDao.findById(id);

        if (newClaim.isEmpty()) {

            throw new ClaimException("no claim found with id: " + id );
        }

        Claim existingClaim = newClaim.get();

        existingClaim.setClaimDate(claim.getClaimDate());
        existingClaim.setClaimNumber(claim.getClaimNumber());
        existingClaim.setClaimStatus(claim.getClaimStatus());
        existingClaim.setDescription(claim.getDescription());

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
}
