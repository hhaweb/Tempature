package com.tempature.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GeneralResponse {
	Object responseObj;
	boolean status;
	String message;
	public GeneralResponse(Object responseObj, boolean status, String message) {
		super();
		this.responseObj = responseObj;
		this.status = status;
		this.message = message;
	}
	
	
}
