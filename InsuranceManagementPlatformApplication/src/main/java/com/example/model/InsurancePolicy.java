package com.example.model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String policyNumber;
    @NotBlank
    private String type;
    @NotBlank
    private Double coverageAmount;
    @NotBlank
    private Double premium;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "client_id")
    private Client client;


}
