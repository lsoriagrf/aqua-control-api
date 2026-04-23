package com.bethlisdev.aqua_control_api.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bethlisdev.aqua_control_api.entity.WaterMetricEntity;
import com.bethlisdev.aqua_control_api.repository.WaterMetricRepository;
import com.bethlisdev.aqua_control_api.service.impl.WaterMetricServiceImpl;

@Service
public class WaterMetricService implements WaterMetricServiceImpl{
	
	@Autowired
    private WaterMetricRepository repository;

	@Override
	public Optional<WaterMetricEntity> getWaterMetricById(int id) {
		return repository.findById(id);
	}

}
