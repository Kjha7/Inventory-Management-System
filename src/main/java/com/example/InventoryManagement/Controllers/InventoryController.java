package com.example.InventoryManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.InventoryManagement.Models.Inventory;

@RestController
@CrossOrigin(origins= "*", allowedHeaders = "*")
@RequestMapping("/product")
public class InventoryController {
	@Autowired
	Inventory product;
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public ResponseEntity<?> AddProduct(@RequestBody Inventory inventory) {
		
		
		//return ResponseEntity.ok(product);
		
	}
}
