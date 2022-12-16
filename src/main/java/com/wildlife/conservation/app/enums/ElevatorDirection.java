package com.wildlife.conservation.app.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

@Getter
public enum ElevatorDirection {

	UP("up"),
	DOWN("down"),
	IDLE("idle"),
	NONE("none")
	;
	private String direction;
	
	private ElevatorDirection(String direction) {
		this.direction = direction;
	}
	
	public static ElevatorDirection fetch(String direction) {
		for(ElevatorDirection temp : values()) {
			if(StringUtils.equalsIgnoreCase(temp.getDirection(), direction))
				return temp;
		}
		throw new IllegalArgumentException("Direction with name '"+direction+"' not found");
	}
}
