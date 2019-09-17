package com.example.InventoryManagement.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.InventoryManagement.Models.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String>{
	
	public Inventory findByProductId(String productId);
	public List<Inventory> findByCategory(String category);
	public List<Inventory> findByName(String name);
	

}
