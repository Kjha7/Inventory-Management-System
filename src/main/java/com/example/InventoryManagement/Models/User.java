package com.example.InventoryManagement.Models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	@Id
	public UUID UserId;
	public String Username;
	public String Password;
	public String EmailId;
	public Integer Age;
	
	public User(String username, String password, String emailId, Integer age) {
		super();
		Username = username;
		Password = password;
		EmailId = emailId;
		Age = age;
		UserId = UUID.randomUUID();
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
