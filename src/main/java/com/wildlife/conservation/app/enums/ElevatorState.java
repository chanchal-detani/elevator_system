package com.wildlife.conservation.app.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

@Getter
public enum ElevatorState {

	MOVING("moving"),
	IDLE("idle"),
	STOPPED("stopped"),
	UNDERMAINTAINANCE("under-maintainance")
	;
	private String state;
	private ElevatorState(String state) {
		this.state = state;
	}
	
	public static ElevatorState fetch(String state) {
		for(ElevatorState temp : values()) {
			if(StringUtils.equalsIgnoreCase(temp.getState(), state))
				return temp;
		}
		throw new IllegalArgumentException("Elevator with state '"+state+"' not found");
	}
}
