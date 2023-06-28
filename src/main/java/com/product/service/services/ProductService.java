package com.product.service.services;

import java.util.List;

import com.product.service.entities.Product;
import com.product.service.normal.response.dto.ProductResponseDto;

public interface ProductService<T> {

	// CREATE
	T createProduct(Product productDto);
	
	// GET ALL
	T getAllProducts();
	
	// GET BY ID
	T getProductById(String productId);
	
	// DELETE
	T deleteProduct(String productId);
	
	List<ProductResponseDto> getProductByUserId(String userId);
	
	
}
