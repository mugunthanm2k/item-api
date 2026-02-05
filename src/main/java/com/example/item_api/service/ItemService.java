package com.example.item_api.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.example.item_api.model.Item;
import jakarta.validation.Valid;

@Service
public class ItemService {

	private final List<Item> items = new ArrayList<>();
	private final AtomicLong idGenerator = new AtomicLong(1);
	
	public Item addItem(@Valid Item item)
	{
		item.setId(idGenerator.getAndIncrement());
		items.add(item);
		return item;
	}
	
	public Optional<Item> getItemById(Long id)
	{
		return items.stream().filter(item -> item.getId().equals(id)).findFirst();
	}
	
	public List<Item> getAllItems()
	{
		return new ArrayList<>(items);
	}
}
