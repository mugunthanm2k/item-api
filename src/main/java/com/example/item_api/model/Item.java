package com.example.item_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Item {

	private Long id;
	
	@NotBlank(message = "Name is required")
	@Size(min = 2, max=50,message= "Name mustbe between 2 and 50 characters")
	private String name;
	
	@NotBlank(message = "Description is required")
	@Size(min =10, max=500, message= "Description must be between 10 to 500 characters")
	private String description;
	
	@NotNull(message="Price is required")
	private Double price;
	
	private String category;
	
	public Item()
	{}

	public Item(String name, String description, Double price, String category) 
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

	
}

