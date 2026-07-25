package com.dcl.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;
	
	private Boolean isActive=true;
	
	@OneToOne(mappedBy = "user",cascade=CascadeType.ALL)
	private Profile profile;

}
