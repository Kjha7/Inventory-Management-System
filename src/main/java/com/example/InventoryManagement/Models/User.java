package com.example.InventoryManagement.Models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public String UserId;
	public String username;
	public String password;
	public String EmailId;
	public Integer Age;
	public String role;
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {}
	
	public User(String role, String Username, String password, String emailId, Integer age) {
		super();
		this.role = role;
		this.username = Username;
		this.password = password;
		EmailId = emailId;
		Age = age;
		UserId = UUID.randomUUID().toString();
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String Username) {
		this.username = Username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
}
