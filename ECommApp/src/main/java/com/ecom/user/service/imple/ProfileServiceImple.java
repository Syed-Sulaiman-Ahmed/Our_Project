package com.ecom.user.service.imple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.user.dto.ProfileDto;
import com.ecom.user.entity.Profile;
import com.ecom.user.exception.AppException;
import com.ecom.user.repo.ProfileRepository;
import com.ecom.user.request.UpadateProfileRequest;
import com.ecom.user.response.CloudinaryResponse;
import com.ecom.user.service.CloudinaryService;
import com.ecom.user.service.ProfileService;


@Service
public class ProfileServiceImple implements ProfileService {
	
	@Autowired
	private ProfileRepository prepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CloudinaryService cservice;	

	@Override
	public ProfileDto addProfile(Profile profile) {
		if(profile.getProfileId()!=null && prepo.existsById(profile.getProfileId())) {
			throw new AppException("This Profile is already exists", HttpStatus.CONFLICT);
		}
		
		Profile newProfile = mapper.map(profile, Profile.class);
		prepo.save(newProfile);
		
		ProfileDto dto = mapper.map(newProfile, ProfileDto.class);
		
		return dto;
	}

	@Override
	public ProfileDto getProfileById(Integer profileId) {
		Profile profile= prepo.findById(profileId).orElseThrow(()->new AppException("Profile Not Found", HttpStatus.NOT_FOUND));
		ProfileDto dto= mapper.map(profile, ProfileDto.class);
		return dto;
	}

	@Override
	public ProfileDto updateProfile(Integer profileId, UpadateProfileRequest request, MultipartFile image) {
		//validating weather profile exists or not
		Profile existingProfile=prepo.findById(profileId).orElseThrow(()->new AppException("Profile not Found", HttpStatus.NOT_FOUND));
		
		//Adding structured data to update
		mapper.map(request, existingProfile);
		
		//checking Image is avaliable or not
		if(image!=null && image.isEmpty()) {
//			checking if already any image is upload
			if(existingProfile.getImagePublicId()!=null) {
				cservice.deleteImage(existingProfile.getImagePublicId());
			}
			CloudinaryResponse response=cservice.uploadingImage(image);
			existingProfile.setImageUrl(response.getImageUrl());
			existingProfile.setImagePublicId(response.getPublicId());
		}
		existingProfile=prepo.save(existingProfile);
		
		return mapper.map(existingProfile, ProfileDto.class);
	}
	

}
