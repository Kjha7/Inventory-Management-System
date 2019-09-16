package com.example.InventoryManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.InventoryManagement.Models.Request.UserRequest;
import com.example.InventoryManagement.Services.UserServices;

import Configs.JwtTokenUtil;

/*
 * Login, logut using jwt;
 * */


@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
	
	@Autowired
	public UserServices userServices;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@RequestMapping(value= "login", method = RequestMethod.POST)
	public String Login(@RequestBody UserRequest userRequest) throws Exception{
		userServices.authenticate(userRequest.getUsername(), userRequest.getPassword());
		return pwd;
		
	}

}
