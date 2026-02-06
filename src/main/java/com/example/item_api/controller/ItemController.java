package com.example.item_api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.item_api.model.Item;
import com.example.item_api.service.ItemService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://mugunthanm2k.github.io/item-api-frontend")
@RequestMapping("api/items")
@Validated
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public ResponseEntity<Item> addItem(@Valid @RequestBody Item item)
	{
		Item savedItem = itemService.addItem(item);
		return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id)
	{
		Optional<Item> item = itemService.getItemById(id);
		return item.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> getAllItems()
	{
		return ResponseEntity.ok(itemService.getAllItems());
	}
	
	
}

