package com.example.InventoryManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.InventoryManagement.DAO.InventoryRepository;
import com.example.InventoryManagement.Models.Inventory;

@Service
public class InventoryServices {

	@Autowired
	InventoryRepository inventory;
	@SuppressWarnings("unchecked")
	public void addProduct(Inventory product) throws Exception{
		if(inventory != null) {
			try {
				inventory.insert(product);
				inventory.save(product);
			}catch(Exception e) {
				System.out.println("Service adding product: "+e);
			}
		}
		
	}

}
