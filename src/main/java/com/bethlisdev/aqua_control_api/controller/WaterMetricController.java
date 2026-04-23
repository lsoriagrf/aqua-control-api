package com.bethlisdev.aqua_control_api.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bethlisdev.aqua_control_api.dto.WaterMetricDto;
import com.bethlisdev.aqua_control_api.service.WaterMetricService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aquacontrol/api/v1/watermetric")
public class WaterMetricController {
	
	private final WaterMetricService waterMetricService;
	
	@GetMapping(path = "/{id}")
    public Optional<WaterMetricDto> getWaterMetricById(@PathVariable int id) {
        return waterMetricService.getWaterMetricById(id);
    }
}
