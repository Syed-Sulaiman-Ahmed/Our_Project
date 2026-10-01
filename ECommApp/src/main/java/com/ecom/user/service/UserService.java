package com.ecom.user.service;

import com.ecom.user.dto.UserDto;
import com.ecom.user.request.LoginRequest;
import com.ecom.user.request.RegisterRequest;

public interface UserService {

	public UserDto register(RegisterRequest request);
	
	public UserDto login(LoginRequest request);


}
