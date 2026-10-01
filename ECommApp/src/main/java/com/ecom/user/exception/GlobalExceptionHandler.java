package com.ecom.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecom.user.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<?> handleAppException(AppException exception){
		return new ResponseEntity<>(new ApiResponse<>(exception.getMessage(),null,exception.getHttpStatus()),
													exception.getHttpStatus());
	}

}
