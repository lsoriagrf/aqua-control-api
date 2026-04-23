package com.bethlisdev.aqua_control_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bethlisdev.aqua_control_api.entity.WaterMetricEntity;
import com.bethlisdev.aqua_control_api.repository.WaterMetricRepository;
import com.bethlisdev.aqua_control_api.service.WaterMetricService;

@ExtendWith(MockitoExtension.class)
public class WaterMetricServiceTest {
	
	@Mock
	private WaterMetricRepository waterMetricRepository;
	
	@InjectMocks
	private WaterMetricService waterMetricService;
	
	@Test
	void shouldReturnMetricWhenIdExists() {
	    // Arrange
	    int id = 1;
	    WaterMetricEntity entity = new WaterMetricEntity();
	    entity.setId(1);
	    entity.setLevelPercentage("85%");
	    
	    when(waterMetricRepository.findById(id)).thenReturn(Optional.of(entity));

	    // Act
	    Optional<WaterMetricEntity> result = waterMetricService.getWaterMetricById(id);

	    // Assert
	    assertNotNull(result);
	    assertEquals("85%", result.get().getLevelPercentage());
	}

}
