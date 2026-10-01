package com.ecom.user.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpadateProfileRequest {
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private LocalDate dob;

}
