package com.bethlisdev.aqua_control_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ValveDto {

    @NotNull(message = "Statis id is required")
    @Positive(message = "Status id must be greater than 0")
    private Integer statuId;
    
    @NotBlank(message = "Created by is required")
    private String createdBy;
}
