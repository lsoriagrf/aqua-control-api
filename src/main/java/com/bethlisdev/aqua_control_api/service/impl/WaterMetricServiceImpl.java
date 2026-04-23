package com.bethlisdev.aqua_control_api.service.impl;

import java.util.Optional;

import com.bethlisdev.aqua_control_api.entity.WaterMetricEntity;

public interface WaterMetricServiceImpl {
	
	public Optional<WaterMetricEntity> getWaterMetricById(int id);
	
}
