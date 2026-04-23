package com.bethlisdev.aqua_control_api.enums;

public enum ValveStatusEnum {
	
	ValveStatusOpen(1, "Open"),
	ValveStatusClosed(2,"Closed");
	
	int id;
	String description;
	
	ValveStatusEnum(int id, String description){
		this.id = id;
		this.description = description;
	}
	
}
