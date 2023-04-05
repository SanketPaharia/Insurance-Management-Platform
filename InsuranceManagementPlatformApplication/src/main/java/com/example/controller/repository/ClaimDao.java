package com.example.controller.repository;

import com.example.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClaimDao extends JpaRepository<Claim, Integer> {

}
