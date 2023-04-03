package com.example.demo.repository;

import com.example.demo.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClaimDao extends JpaRepository<Claim, Integer> {

}
