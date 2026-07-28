package com.dcl.response;

import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	private String message;
	
	private HttpStatusCode httpStatus;

}
