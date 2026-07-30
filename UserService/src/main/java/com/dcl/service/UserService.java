package com.dcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcl.dto.UserDto;
import com.dcl.request.RegisterRequest;


@Service
public interface UserService {
	
	UserDto addUser(RegisterRequest q);
	
//	void updateUser(Integer userId);
	
	void deleteUser(Integer userId);
	
	UserDto getUserByID(Integer userId);
	
	List<UserDto> getAllUser();
	
	

	
}
