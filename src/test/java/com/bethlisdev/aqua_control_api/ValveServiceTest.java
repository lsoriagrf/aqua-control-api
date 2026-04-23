package com.bethlisdev.aqua_control_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bethlisdev.aqua_control_api.dto.ValveDto;
import com.bethlisdev.aqua_control_api.entity.WaterValveEntity;
import com.bethlisdev.aqua_control_api.repository.ValveRepository;
import com.bethlisdev.aqua_control_api.service.impl.ValveServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ValveServiceTest {
	
	@Mock
	private ValveRepository valveRepository;
	
	@InjectMocks
	private ValveServiceImpl valveService;
	
	@Test
	void shouldReturnSuccessMessageWhenValveIsSet() {
	    // Arrange
	    String expectedMessage = "Valve configured correctly";
	    ValveDto valveDto = new ValveDto(1, "7896541");
	    
	    // Act
	    String result = valveService.setValve(valveDto);
	    
	    // Assert
	    assertEquals(expectedMessage, result);
	    verify(valveRepository).save(any(WaterValveEntity.class));
	}

}
