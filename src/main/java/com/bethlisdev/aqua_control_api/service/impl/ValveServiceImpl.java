package com.bethlisdev.aqua_control_api.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.bethlisdev.aqua_control_api.dto.ValveDto;
import com.bethlisdev.aqua_control_api.entity.WaterValveEntity;
import com.bethlisdev.aqua_control_api.repository.ValveRepository;
import com.bethlisdev.aqua_control_api.service.ValveService;
import com.bethlisdev.aqua_control_api.service.impl.ValveServiceImpl;

@Service
public class ValveServiceImpl implements ValveService{

	private final ValveRepository waterValveRepository;

	public ValveServiceImpl(ValveRepository waterValveRepository) {
		this.waterValveRepository = waterValveRepository;
	}	

	@Override
	public String setValve(ValveDto valveDto) {
		WaterValveEntity waterValveEntity = new WaterValveEntity();
		waterValveEntity.setStatusId(valveDto.getStatuId());
		waterValveEntity.setCreatedAt(LocalDateTime.now());
		waterValveEntity.setCreatedBy(valveDto.getCreatedBy());
		waterValveRepository.save(waterValveEntity);
		return "Valve configured correctly";
	}
	
	
}
