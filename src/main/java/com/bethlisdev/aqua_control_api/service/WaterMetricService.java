package com.bethlisdev.aqua_control_api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bethlisdev.aqua_control_api.entity.WaterMetricEntity;
import com.bethlisdev.aqua_control_api.service.impl.WaterMetricServiceImpl;

@Service
public class WaterMetricService implements WaterMetricServiceImpl{

	@Override
	public Optional<WaterMetricEntity> getWaterMetricById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


}
