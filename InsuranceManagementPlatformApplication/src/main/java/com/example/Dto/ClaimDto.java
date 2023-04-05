package com.example.Dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ClaimDto {

    @NotBlank
    private String claimNumber;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate claimDate;
    @NotBlank
    private String claimStatus;

    private Integer insuranceId;

    private Integer clientId;
}
