package com.ecom.user.service.imple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecom.user.dto.RoleDto;
import com.ecom.user.entity.Role;
import com.ecom.user.enume.RoleType;
import com.ecom.user.exception.AppException;
import com.ecom.user.repo.RoleRepository;
import com.ecom.user.request.AddRoleRequest;
import com.ecom.user.service.RoleService;

@Service
public class RoleServiceImple implements RoleService {
	
	@Autowired
	private RoleRepository rrepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public RoleDto addRole(AddRoleRequest request) {
		Role alreadyExists=rrepo.findByRoleName(request.getRoleName()).orElse(null);
		if(alreadyExists!=null) {
			throw new AppException("Role already Exists", HttpStatus.CONFLICT);
		}
		Role role= mapper.map(request,Role.class);
		role=rrepo.save(role);
		RoleDto dto =mapper.map(role,RoleDto.class);
		return dto;
	}

	@Override
	public RoleDto getRoleByRoleName(RoleType roleName) {
		Role role=rrepo.findByRoleName(roleName).orElseThrow(()->new AppException("Role Not Found", HttpStatus.NOT_FOUND));
		RoleDto dto=mapper.map(role, RoleDto.class);
		return dto;
	}

}
