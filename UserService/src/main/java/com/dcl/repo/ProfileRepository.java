package com.dcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
