package com.example.InventoryManagement.Models.Request;

public class LoginRequest {
	public String Username;
	public String Password;
	public LoginRequest() {}
	public LoginRequest(String username, String password) {
		Username = username;
		Password = password;
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

}
