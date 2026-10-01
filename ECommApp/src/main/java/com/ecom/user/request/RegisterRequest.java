package com.ecom.user.request;

import java.time.LocalDate;

import com.ecom.user.enume.RoleType;

import lombok.Data;

@Data
public class RegisterRequest {
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private LocalDate dob;
	
	private RoleType roleName;

}
