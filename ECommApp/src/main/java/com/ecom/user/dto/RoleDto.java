package com.ecom.user.dto;

import com.ecom.user.enume.RoleType;

import lombok.Data;
@Data
public class RoleDto {
	
	private Integer roleId;
	
	private RoleType roleName;

}
