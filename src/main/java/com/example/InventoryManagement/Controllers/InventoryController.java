package com.example.InventoryManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.Models.Inventory;
import com.example.InventoryManagement.Services.InventoryServices;

@RestController
@CrossOrigin(origins= "*", allowedHeaders = "*")
@RequestMapping("/product")
public class InventoryController {
	@Autowired
	InventoryServices services;
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public ResponseEntity<?> AddProduct(@RequestBody Inventory inventory) {
		try {
			services.addProduct(inventory);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
