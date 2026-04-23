package com.bethlisdev.aqua_control_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class WaterMetricDto {

    private Integer id;

    private String levelPercentage;

}
