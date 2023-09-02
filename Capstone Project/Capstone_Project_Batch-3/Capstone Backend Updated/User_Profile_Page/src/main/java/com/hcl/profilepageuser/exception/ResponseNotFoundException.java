package com.hcl.profilepageuser.exception;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
//this is class for response not found exception
public class ResponseNotFoundException extends RuntimeException{
	private String msg;
//message is sent to parent class
	public ResponseNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
