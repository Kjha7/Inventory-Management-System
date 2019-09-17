package com.example.InventoryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.InventoryManagement.Models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByUsername(String username);
	public List<User> findByRole(String role);

}
