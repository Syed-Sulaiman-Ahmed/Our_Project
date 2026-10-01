package com.ecom.user.service.imple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ecom.user.dto.ProfileDto;
import com.ecom.user.dto.RoleDto;
import com.ecom.user.dto.UserDto;
import com.ecom.user.entity.Profile;
import com.ecom.user.entity.Role;
import com.ecom.user.entity.User;
import com.ecom.user.exception.AppException;
import com.ecom.user.repo.UserRepository;
import com.ecom.user.request.LoginRequest;
import com.ecom.user.request.RegisterRequest;
import com.ecom.user.service.ProfileService;
import com.ecom.user.service.RoleService;
import com.ecom.user.service.UserService;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;

@Server
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RoleService rservice;
	
	@Autowired
	private ProfileService pservice;

	
	@Transactional
	@Override
	public UserDto register(RegisterRequest request) {
		User alreadyExists=urepo.findByEmail(request.getEmail()).orElse(null);
		if(alreadyExists!=null || urepo.existsByEmail(request.getEmail())) {
			throw new AppException("User already exists",HttpStatus.CONFLICT);
		}
		
		//logic for adding user data
		User newUser = mapper.map(request, User.class);
		
		RoleDto rdto = rservice.getRoleByRoleName(request.getRoleName());
		System.out.println(rdto.getRoleName());
		newUser.setRole(mapper.map(rdto, Role.class));
		newUser=urepo.save(newUser);
		
		// now creating the profile for the user
		
		Profile profile= mapper.map(request, Profile.class);
		profile.setUser(newUser);
		ProfileDto pdto=pservice.addProfile(profile);
		
		UserDto dto = mapper.map(newUser, UserDto.class);
		dto.setPdto(pdto);
		dto.setRdto(rdto);
		
		
		
		
		
		return dto;
	}

	@Override
	public UserDto login(LoginRequest request) {
		 User alreadyExists=urepo.findByEmail(request.getEmail()).orElse(null);
		 if(alreadyExists!=null) {
			 if(alreadyExists.getPassword().equals(request.getPassword())) {
				 return mapper.map(alreadyExists, UserDto.class);
			 }
			 else {
				 throw new AppException("Invalid Credentials", HttpStatus.CONFLICT);
			 }
			 }
		 else {
			 throw new AppException("User not Found", HttpStatus.NOT_FOUND);
		 }
	}

}
