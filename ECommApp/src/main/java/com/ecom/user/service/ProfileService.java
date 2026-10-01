package com.ecom.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.user.dto.ProfileDto;
import com.ecom.user.entity.Profile;
import com.ecom.user.request.UpadateProfileRequest;

public interface ProfileService {
	
	public ProfileDto addProfile(Profile profile);
	
	public ProfileDto getProfileById(Integer profileId);
	
	public ProfileDto updateProfile(Integer profileId, UpadateProfileRequest request, MultipartFile image);

}
