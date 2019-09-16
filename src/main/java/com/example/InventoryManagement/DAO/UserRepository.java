package com.example.InventoryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.InventoryManagement.Models.User;


public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByUserName(String username);
	public List<User> findByRole(String role);

}
