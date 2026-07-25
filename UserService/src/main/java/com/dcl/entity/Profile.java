package com.dcl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique=true)
	private String phoneNo;
	
	private String dob;
	
	private String imageUrl;
	
	private String publicUrl;
	
	private String gender;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
}
