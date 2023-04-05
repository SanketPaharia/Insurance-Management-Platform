package com.example.Dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
public class InsurancePolicyDto {


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

}
