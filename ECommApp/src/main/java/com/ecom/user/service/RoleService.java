package com.ecom.user.service;

import com.ecom.user.dto.RoleDto;
import com.ecom.user.enume.RoleType;
import com.ecom.user.request.AddRoleRequest;

public interface RoleService {
	
	public RoleDto addRole(AddRoleRequest request);
	
	public RoleDto getRoleByRoleName(RoleType roleName);

}
