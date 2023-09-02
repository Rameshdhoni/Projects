package com.hcl.profilepageadmin.exception;

public class ResponseAlreadyExistsException extends RuntimeException {
	private String msg;
	//message is sent to parent class
		public ResponseAlreadyExistsException(String msg) {
			super(msg);
			this.msg = msg;
		}
		

}
