package com.dcl.service;

import java.util.List;

import com.dcl.entity.Role;

public interface RoleService {

	Role addRole(String roleName);
	
	List<Role> getAllRole();
}
