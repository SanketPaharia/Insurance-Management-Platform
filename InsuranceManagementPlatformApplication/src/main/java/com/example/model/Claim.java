package com.example.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String claimNumber;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate claimDate;
    @NotBlank
    private String claimStatus;

    @OneToOne
    private Client client;

    @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private InsurancePolicy insurancePolicy;


}
