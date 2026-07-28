package com.dcl.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProfileDto {

	private String firstName;
	
	private String lastName;
	
	private String phoneNo;
	
	private LocalDate dob;
	
	private Integer profileId;
	
	 
}
