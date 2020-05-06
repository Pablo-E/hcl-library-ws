package com.hcl.library.app.ws.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

	private String errorMessage;
	private String errorMessageKey;

	public ErrorMessage(){};
	
	public ErrorMessage(String errorMessage, String errorMessageKey) {
		super();
		this.errorMessage = errorMessage;
		this.errorMessageKey = errorMessageKey;
	}
	
}
