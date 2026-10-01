package com.ecom.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.user.entity.Role;
import java.util.List;
import com.ecom.user.enume.RoleType;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByRoleName(RoleType roleName);

}
