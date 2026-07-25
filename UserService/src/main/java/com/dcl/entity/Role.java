package com.dcl.entity;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Role {

	private Integer roleId;
	
	private String roleName;
	
	private List<User> users;
}
