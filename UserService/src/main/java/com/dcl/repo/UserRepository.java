package com.dcl.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dcl.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("Select u from User u where u.email=:email")
	Optional<User> findByemail(String email);
	

}
