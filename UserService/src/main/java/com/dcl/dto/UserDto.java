package com.dcl.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {

	private String email;
	
	private Integer userId;
	
	private LocalDateTime createdAt;
	
	private ProfileDto profileDto;
	
	private RoleDto roleDto;
}
