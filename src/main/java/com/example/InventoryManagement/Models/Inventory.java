
package com.example.InventoryManagement.Models;

import org.springframework.data.annotation.Id;


public class Inventory {
	@Id
	public String ProductId;
	public String Category;
	public String Name;
	public String Description;
	public String Price;
	
	public Inventory(String productId, String category, String name, String description, String price) {
		super();
		ProductId = productId;
		Category = category;
		Name = name;
		Description = description;
		Price = price;
	}
	
	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

		

}
