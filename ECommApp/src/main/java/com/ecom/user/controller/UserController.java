package com.ecom.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.user.dto.UserDto;
import com.ecom.user.request.LoginRequest;
import com.ecom.user.request.RegisterRequest;
import com.ecom.user.response.ApiResponse;
import com.ecom.user.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uservice;

	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
		UserDto dto=uservice.register(request);
		return ResponseEntity.ok(new ApiResponse<>("User Registeration successfully", dto, HttpStatus.OK));
	}
	
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		UserDto dto=uservice.login(request);
		return ResponseEntity.ok(new ApiResponse<>("Login Successfully", dto, HttpStatus.OK));
	}
}

