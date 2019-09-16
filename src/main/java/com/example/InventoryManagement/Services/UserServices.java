package com.example.InventoryManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.InventoryManagement.DAO.UserRepository;
import com.example.InventoryManagement.Models.User;
import com.example.InventoryManagement.Models.Request.UserRequest;
import com.mongodb.MongoWriteException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import Configs.JwtTokenUtil;

@Service
public class UserServices {

	@Autowired
	public UserRepository user;
	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	@Autowired
	public AuthenticationManager authenticationManager;
	
	public void authenticate(String username, String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("User_Diabled " +e);
		}catch(BadCredentialsException e) {
			throw new Exception("Wrong Credentials "+e);
		}
		
		
	}
	
	public User loadUserByUsername(String Username) {	
		return user.findByUserName(Username);
		
	}

	public void addUser(User userRequest) throws Exception{
		if(userRequest != null) {
			try {
			user.insert(userRequest);
			user.save(userRequest);
			}catch(MongoWriteException e) {
				throw new Exception("Error while creating new user "+e);
			} 
		}
		else {
			throw new Exception("User object is empty");
		}
		
	}

}
