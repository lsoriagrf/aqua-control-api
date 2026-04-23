package com.bethlisdev.aqua_control_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bethlisdev.aqua_control_api.entity.WaterMetricEntity;
import com.bethlisdev.aqua_control_api.entity.WaterValveEntity;

@Repository
public interface ValveRepository extends JpaRepository<WaterValveEntity, Integer>{

}
