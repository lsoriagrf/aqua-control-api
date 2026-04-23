package com.bethlisdev.aqua_control_api.service;

import java.util.Optional;
import com.bethlisdev.aqua_control_api.dto.WaterMetricDto;

public interface WaterMetricService {
	
	public Optional<WaterMetricDto> getWaterMetricById(int id);
	
}
