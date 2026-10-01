package com.ecom.user.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
	
	private String message;
	
	private HttpStatus httpStatus;
	
	public AppException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus=httpStatus;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	

}
