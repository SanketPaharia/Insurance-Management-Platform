package com.example.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String address;

    @NotBlank
    private Long contactInformation;

    @OneToMany(mappedBy = "client")
    private Set<InsurancePolicy> insurancePolicies = new HashSet<>();
}
