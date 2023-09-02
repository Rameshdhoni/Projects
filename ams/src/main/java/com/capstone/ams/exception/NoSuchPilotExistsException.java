package com.capstone.ams.exception;

//NoSuchpilotExistsException class
public class NoSuchPilotExistsException extends RuntimeException {
	
	private String message;

	public NoSuchPilotExistsException(String msg) {
		super(msg);
		this.setMessage(msg);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;
	
	

}
