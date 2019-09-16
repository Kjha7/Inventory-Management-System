package com.example.InventoryManagement.Models.Request;

public class UserResponse {

	private final String jwtToken;

	public UserResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	public String getToken(String token) {
		return this.jwtToken;
	}
	
	
}
