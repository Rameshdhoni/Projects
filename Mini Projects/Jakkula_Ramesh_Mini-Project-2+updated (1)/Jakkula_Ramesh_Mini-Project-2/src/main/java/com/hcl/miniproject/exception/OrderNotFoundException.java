package com.hcl.miniproject.exception;

public class OrderNotFoundException extends RuntimeException {
	private String message;

	public OrderNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public OrderNotFoundException() {
	}
}
