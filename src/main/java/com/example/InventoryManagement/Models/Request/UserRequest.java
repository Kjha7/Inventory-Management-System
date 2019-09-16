package com.example.InventoryManagement.Models.Request;

public class UserRequest {
	
	public String Username;
	public String Password;
	public String EmailId;
	public Integer Age;
	public UserRequest(String username, String password, String emailId, Integer age) {
		super();
		Username = username;
		Password = password;
		EmailId = emailId;
		Age = age;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
