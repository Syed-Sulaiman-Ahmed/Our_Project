package com.ecom.user.service;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.user.response.CloudinaryResponse;

public interface CloudinaryService {
	
	CloudinaryResponse uploadingImage(MultipartFile image);
	
	void deleteImage(String publicId);

}
