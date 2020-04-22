package com.rahdevelopers.api.items.apicontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rahdevelopers.api.items.dto.ItemDto;
import com.rahdevelopers.api.items.dto.ProductoDto;
import com.rahdevelopers.api.items.service.ItemService;

@RestController
public class ItemApiController {

	@Autowired
	private ItemService itemService;

	@HystrixCommand(fallbackMethod = "getLitarItemsError")
	@GetMapping("/listar")
	public List<ItemDto> getLitarItems() {
		return this.itemService.findAll();
	}

	@HystrixCommand(fallbackMethod = "getItemError")
	@GetMapping("/{id}/cantidad/{cantidad}")
	public ItemDto getItem(@PathVariable Long id, @PathVariable Integer cantidad) {
		return this.itemService.findById(id, cantidad);
	}
	
	public ItemDto getItemError(Long id, Integer cantidad) {
		ProductoDto productoDto = new ProductoDto();
		productoDto.setID(id);
		productoDto.setNombre("Error Inesperado");
		productoDto.setPrecio(0L);
		productoDto.setFechaCreacion(new Date());
		productoDto.setPort(0);
		
		return new ItemDto(productoDto, cantidad);
	}
	
	public List<ItemDto> getLitarItemsError() {

		ProductoDto productoDto = new ProductoDto();

		productoDto.setID(0L);
		productoDto.setNombre("Error Inesperado");
		productoDto.setPrecio(0L);
		productoDto.setFechaCreacion(new Date());
		productoDto.setPort(0);

		List<ItemDto> listItemDtos = new ArrayList<>();
		listItemDtos.add(new ItemDto(productoDto, 0));

		return listItemDtos;
	}
}
