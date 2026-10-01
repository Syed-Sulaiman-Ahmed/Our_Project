package com.ecom.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.user.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	

}
