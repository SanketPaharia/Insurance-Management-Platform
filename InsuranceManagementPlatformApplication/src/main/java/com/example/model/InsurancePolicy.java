package com.example.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotBlank
    private String policyNumber;
//    @NotBlank
    private String type;
//    @NotBlank
    private Double coverageAmount;
//    @NotBlank
    private Double premium;
//    @NotNull
    private LocalDate startDate;
//    @NotNull
    private LocalDate endDate;

    @JsonIgnore
    @ManyToOne
    private Client client;

    @JsonIgnore
    @OneToOne
    private Claim claim;
}
