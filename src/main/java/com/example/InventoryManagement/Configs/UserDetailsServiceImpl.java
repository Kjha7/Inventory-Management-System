package com.example.InventoryManagement.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.InventoryManagement.DAO.UserRepository;
import com.example.InventoryManagement.Models.Request.LoginRequest;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.example.InventoryManagement.Models.User user = userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
			 
		}
		else {
			return new User(user.getUsername(),user.getPassword(), emptyList());
		}
	}

}
