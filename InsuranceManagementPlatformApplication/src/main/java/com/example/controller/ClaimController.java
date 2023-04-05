package com.example.controller;


import com.example.model.Claim;
import com.example.model.Client;
import com.example.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ClaimController {

    @Autowired
    ClaimService claimService ;


    @PostMapping("/claims")
    public ResponseEntity<Claim> addClaimHandler(@Valid @RequestBody Claim claim) {
        Claim newClaim = claimService.createClaim(claim);
        return new ResponseEntity<>(newClaim, HttpStatus.CREATED);
    }


    @GetMapping("/claims/{id}")
    public ResponseEntity<Claim> findClaimHandler(@PathVariable Integer id){

    Claim claim = claimService.findClaimById(id);
        return new ResponseEntity<>(claim,HttpStatus.FOUND);
    }

    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getListOfAllClaimsHandler(){

        List<Claim> list = claimService.findAllClaims();


        return new ResponseEntity<>(list ,HttpStatus.FOUND);
    }

    @PutMapping("/claims/{id}")
    public ResponseEntity<Claim> updateClaim(@Valid  @PathVariable Integer id, @RequestBody Claim claim) {

        claimService.updateClaim(id , claim);

        return new ResponseEntity<>(claim ,HttpStatus.OK);
    }

    @DeleteMapping("/claims/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable int id) {
        String result =  claimService.deleteClaim(id);

        return new ResponseEntity<>(result , HttpStatus.ACCEPTED );
    }
}
