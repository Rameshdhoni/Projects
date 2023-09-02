package com.capstone.ams.exception;


//NoSuchplanetExistsException class
public class NoSuchPlaneExistsException extends RuntimeException {

	private String message;

	public NoSuchPlaneExistsException(String msg) {
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
