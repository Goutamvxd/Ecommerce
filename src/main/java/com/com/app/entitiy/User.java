package com.com.app.entitiy;

import com.com.app.constants.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user_tab")
@Data

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id_col")
	private Long id;
	
	@Column(name="user_name_col",length = 45,nullable = false)
	private String displayName;
	
	@Column(name="user_email_col",length = 75,nullable = false,unique = true)
	private String email;
	
	@Column(name="user_pwd_col",length = 120,nullable = false,unique = true)
	private String password;
	
	@Column(name="user_status_col",nullable=false)
	private String status;
	
	@Column(name="user_contact_col",nullable = false)
	private String contact;
	
	@Column(name="user_role_col",nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column(name="user_address_col",nullable = false)
	private String address;

}
