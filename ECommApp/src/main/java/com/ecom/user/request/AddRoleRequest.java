package com.ecom.user.request;

import com.ecom.user.enume.RoleType;

import lombok.Data;

@Data
public class AddRoleRequest {
	
	private RoleType roleName;

}
