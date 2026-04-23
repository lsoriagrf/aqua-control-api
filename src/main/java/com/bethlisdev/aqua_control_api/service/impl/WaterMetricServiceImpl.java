package com.bethlisdev.aqua_control_api.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bethlisdev.aqua_control_api.dto.WaterMetricDto;
import com.bethlisdev.aqua_control_api.repository.WaterMetricRepository;
import com.bethlisdev.aqua_control_api.service.WaterMetricService;
import com.bethlisdev.aqua_control_api.service.impl.WaterMetricServiceImpl;

@Service
public class WaterMetricServiceImpl implements WaterMetricService{
	
	private final WaterMetricRepository repository;

    public WaterMetricServiceImpl(WaterMetricRepository repository) {
        this.repository = repository;
    }

	@Override
	public Optional<WaterMetricDto> getWaterMetricById(int id) {
		return repository.findById(id)
	            .map(entity -> new WaterMetricDto(
	                    entity.getId(), 
	                    entity.getLevelPercentage()
	            ));
	}

}
