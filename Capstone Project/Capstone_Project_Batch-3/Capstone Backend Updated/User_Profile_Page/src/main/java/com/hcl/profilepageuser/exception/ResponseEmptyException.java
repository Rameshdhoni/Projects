package com.hcl.profilepageuser.exception;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
//this is ResponseEmptyException class extends with runtimeException
public class ResponseEmptyException extends RuntimeException{
	private String msg;
//the message is sent to the parent class
	public ResponseEmptyException(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
