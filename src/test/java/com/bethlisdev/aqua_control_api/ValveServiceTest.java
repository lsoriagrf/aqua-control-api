package com.bethlisdev.aqua_control_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import com.bethlisdev.aqua_control_api.service.impl.ValveServiceImpl;

public class ValveServiceTest {
	
	@InjectMocks
	private ValveServiceImpl valveService;
	
	@Test
	void shouldReturnSuccessMessageWhenValveIsSet() {
	    // Arrange
	    String expectedMessage = "Valvula configurada correctamente";
	    
	    // Act
	    String result = valveService.setValve();
	    
	    // Assert
	    assertEquals(expectedMessage, result);
	}

}
