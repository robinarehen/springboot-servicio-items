package com.rahdevelopers.api.items.clienterest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rahdevelopers.api.items.dto.ProductoDto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

	@GetMapping("/listar")
	public List<ProductoDto> getListarProductos();
	
	@GetMapping("/ver/{id}")
	public ProductoDto getProducto(@PathVariable Long id);
}
