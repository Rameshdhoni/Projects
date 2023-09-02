package com.hcl.miniproject.exception;

public class MenuNotFoundException extends  RuntimeException {
	private String message;

	public MenuNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public MenuNotFoundException() {
		super();
	}
}
