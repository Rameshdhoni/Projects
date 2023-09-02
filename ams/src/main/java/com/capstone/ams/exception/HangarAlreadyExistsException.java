package com.capstone.ams.exception;

//HangarAlreadyExistsException class
public class HangarAlreadyExistsException extends RuntimeException {
	
	private String message;

	public HangarAlreadyExistsException(String msg) {
		super(msg);
		this.setMessage(msg);
	}

	public HangarAlreadyExistsException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	private static final long serialVersionUID = 1L;

	
}
