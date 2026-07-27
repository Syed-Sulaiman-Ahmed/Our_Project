package com.dcl.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcl.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	
	
	@Query("Select p from Profile p where p.UserId=:userId")
	Optional<Profile> findByUserId(Integer userId);

}
