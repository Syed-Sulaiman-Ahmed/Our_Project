package com.ecom.user.service.imple;

import com.ecom.user.repo.RoleRepository;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecom.user.exception.AppException;
import com.ecom.user.response.CloudinaryResponse;
import com.ecom.user.service.CloudinaryService;

@Service
public class CloudinaryServiceImple implements CloudinaryService {
	
	private final RoleRepository roleRepository;
	@Autowired
	private Cloudinary cloudinary;



	CloudinaryServiceImple(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	

	@Override
	public CloudinaryResponse uploadingImage(MultipartFile image) {
		CloudinaryResponse cloudinaryResponse = null;
		if(image!=null && image.isEmpty()) {
			try {
				Map<?, ?> cloudResponse=cloudinary.uploader()
						.upload(image.getBytes(), ObjectUtils.emptyMap());
				String publicId=(String)cloudResponse.get("public_id");
				String imageUrl=(String)cloudResponse.get("secret_url");
				cloudinaryResponse= new CloudinaryResponse(imageUrl, publicId);
				} catch(IOException e){
					throw new AppException("SomeThing went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
					
				}
		}
		else {
			throw new AppException("Image Not Found", HttpStatus.NOT_FOUND);
		}
		return cloudinaryResponse;
	}

	@Override
	public void deleteImage(String publicId) {
		try {
			Map<?, ?> result=cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
			if(!result.get("result").equals("ok")) {
				throw new AppException("Fail to delete the image", HttpStatus.EXPECTATION_FAILED);
			}
		} catch (IOException e) {
			throw new AppException("Somethings went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
