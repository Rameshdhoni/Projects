package com.hcl.profilepageadmin.exception;
//this is class for response not found exception
public class ResponseNotFoundException extends RuntimeException{
	private String msg;
//message is sent to parent class
	public ResponseNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
