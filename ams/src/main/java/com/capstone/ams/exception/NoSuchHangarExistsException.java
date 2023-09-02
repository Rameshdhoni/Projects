package com.capstone.ams.exception;

//NoSuchHangarExistsException class
public class NoSuchHangarExistsException extends RuntimeException {

	private String message;

	public NoSuchHangarExistsException(String msg) {
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
