package com.rahdevelopers.api.items.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahdevelopers.api.items.dto.ItemDto;
import com.rahdevelopers.api.items.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemApiController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/listar")
	public List<ItemDto> getLitarItems() {
		return this.itemService.findAll();
	}

	@GetMapping("/{id}/cantidad/{cantidad}")
	public ItemDto getItem(@PathVariable Long id, @PathVariable Integer cantidad) {
		return this.itemService.findById(id, cantidad);
	}
}
