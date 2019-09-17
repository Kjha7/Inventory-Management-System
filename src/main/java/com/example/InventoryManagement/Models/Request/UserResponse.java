package com.example.InventoryManagement.Models.Request;

public class UserResponse {
	
	public String userId;
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
	public UserResponse(String userId, String role, String Username, String password, String emailId, Integer age) {
		super();
		this.userId = userId;
		this.username = Username;
		this.password = password;
		EmailId = emailId;
		Age = age;
		this.role = role;
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
