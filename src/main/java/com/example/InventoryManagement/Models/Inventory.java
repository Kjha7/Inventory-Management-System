
package com.example.InventoryManagement.Models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Inventory")
public class Inventory {
	@Id
	public String ProductId;
	public String Category;
	public String Name;
	public String Description;
	public int Price;
	public Integer quantity;
	
	public Inventory( String category, String name, String description, int price, Integer quantity) {
		super();
		ProductId = UUID.randomUUID().toString();
		Category = category;
		Name = name;
		Description = description;
		Price = price;
		this.quantity = quantity;
	}
	
	public String getProductId() {
		return ProductId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

		

}
