package com.example.InventoryManagement.DOA;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.InventoryManagement.Models.User;


public interface UserRepository extends MongoRepository{
	
	public User findByUserName(String username);
	public List<User> findByRole(String role);

}
