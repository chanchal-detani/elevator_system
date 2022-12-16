package com.wildlife.conservation.app.entity;

import com.wildlife.conservation.app.enums.ElevatorDirection;
import com.wildlife.conservation.app.enums.Source;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString
public class Request {
	
	int current;
	int destination;
	Source source; // can be from inside person or can from outside person
	ElevatorDirection direction;
}