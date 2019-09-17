package com.example.InventoryManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.InventoryManagement.Configs.JwtTokenUtil;
import com.example.InventoryManagement.Models.User;
import com.example.InventoryManagement.Models.Request.LoginRequest;
import com.example.InventoryManagement.Models.Request.JwtResponse;
import com.example.InventoryManagement.Services.UserServices;

/*
 * Login, logut using jwt;
 * */


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserServices userServices;
	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ResponseEntity<?> Login(@RequestBody LoginRequest loginRequest) throws Exception{
		userServices.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
		User user = userServices.loadUserByUsername(loginRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(user);	
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value= "/signup", method= RequestMethod.POST)
	public ResponseEntity<?> Signup(@RequestBody User userRequest){
		try {
		userServices.addUser(userRequest);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ResponseEntity<?> getUser(){
		try {
			return ResponseEntity.ok(userServices.getAllUsers());
		}catch(Exception e) {
			System.out.println("Error in retrieving Users: "+e);
		}
		return null;
		
	}

}
