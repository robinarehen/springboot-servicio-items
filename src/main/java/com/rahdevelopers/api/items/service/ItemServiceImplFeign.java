package com.rahdevelopers.api.items.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahdevelopers.api.items.clienterest.ProductoClienteRest;
import com.rahdevelopers.api.items.dto.ItemDto;

@Service
public class ItemServiceImplFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteRest;

	@Override
	public List<ItemDto> findAll() {
		// TODO Auto-generated method stub
		return this.clienteRest.getListarProductos().stream().map(producto -> new ItemDto(producto, 1))
				.collect(Collectors.toList());
	}

	@Override
	public ItemDto findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new ItemDto(this.clienteRest.getProducto(id), cantidad);
	}

}
