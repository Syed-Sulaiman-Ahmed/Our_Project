package com.dcl.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProfileDto {

	private String firstname;
	
	private String lastName;
	
	private String phoneNo;
	
	private LocalDate dob;
	
	private UserDto userDto; 
}
