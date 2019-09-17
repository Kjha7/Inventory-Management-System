package com.example.InventoryManagement.Models.Request;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwtToken;
	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	public String getJwtToken() {
		return jwtToken;
	}

	
}
