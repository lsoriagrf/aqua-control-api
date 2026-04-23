package com.bethlisdev.aqua_control_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bethlisdev.aqua_control_api.service.ValveService;

@ExtendWith(MockitoExtension.class)
public class ValveServiceTest {
	
	@InjectMocks
	private ValveService valveService;
	
	@Test
	void shouldReturnSuccessMessageWhenValveIsSet() {
	    // Arrange
	    String expectedMessage = "Valve configured correctly";
	    
	    // Act
	    String result = valveService.setValve();
	    
	    // Assert
	    assertEquals(expectedMessage, result);
	}

}
