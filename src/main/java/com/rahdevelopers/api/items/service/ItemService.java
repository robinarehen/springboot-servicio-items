package com.rahdevelopers.api.items.service;

import java.util.List;

import com.rahdevelopers.api.items.dto.ItemDto;

public interface ItemService {

	public List<ItemDto> findAll();
	
	public ItemDto findById(Long id, Integer cantidad);
}
