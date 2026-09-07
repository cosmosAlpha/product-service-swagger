package com.jdev.prodready.api.product.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SampleDto {

    private String field1;
    private String field2;
    private String field3;
    private String field4;

    @NotNull
    private BigDecimal field5;
    private Long field6;

    @NotNull
    @Valid
    private Boolean field7;

    @Valid
    @Email
    private String emailAddress;

    private List<SampleDto> sampleDtos;

}
