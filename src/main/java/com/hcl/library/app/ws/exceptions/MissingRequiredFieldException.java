package com.hcl.library.app.ws.exceptions;

public class MissingRequiredFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MissingRequiredFieldException(String message) {
		super(message);
	}
	

}
