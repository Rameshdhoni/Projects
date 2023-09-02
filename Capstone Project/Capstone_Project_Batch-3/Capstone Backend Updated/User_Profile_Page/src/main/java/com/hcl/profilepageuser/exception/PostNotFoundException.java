package com.hcl.profilepageuser.exception;

public class PostNotFoundException extends RuntimeException {
	private String message;

	public PostNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public PostNotFoundException() {
		super();
	}

}


