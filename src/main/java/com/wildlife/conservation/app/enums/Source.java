package com.wildlife.conservation.app.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

@Getter
public enum Source {

	OUTSIDE("outside"),
	INSIDE("inside"),
	;
	private String source;
	
	private Source(String from) {
		this.source = from;
	}
	
	public static Source fetch(String from) {
		for(Source temp : values()) {
			if(StringUtils.equalsIgnoreCase(temp.getSource(), from))
				return temp;
		}
		throw new IllegalArgumentException("Source with name '"+from+"' not found");
	}
}
