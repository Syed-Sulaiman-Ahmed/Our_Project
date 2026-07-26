package com.dcl.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
	
	private String password;
	
    private String firstName;
	
	private String lastName;
	
	private String phoneNo;
	
	private LocalDate dob;
}
