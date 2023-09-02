package com.capstone.ams.exception;

//PilotAlreadyExistsException class
public class PilotAlreadyExistsException extends RuntimeException {
	
	private String message;

	public PilotAlreadyExistsException(String msg) {
		super(msg);
		this.setMessage(msg);
	}

	public PilotAlreadyExistsException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;
		

}
