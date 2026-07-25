package com.dcl.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique=true)
	private String phoneNo;
	
	private LocalDate dob;
	
	private String imageUrl;
	
	private String publicUrl;
	
	private String gender;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
