package com.product.service.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.dto.ProductDto;
import com.product.service.entities.Product;
import com.product.service.normal.response.dto.ProductResponseDto;
import com.product.service.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@SuppressWarnings("unchecked")
public class ProductController<T> {

	@Autowired
	private ProductService<T> productService;
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<T> createProduct(@RequestBody Product productDto) {
		System.out.println(productDto);
		return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.CREATED).body(this.productService.createProduct(productDto));
	}
	
	// DELETE
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<T> deleteProduct(@PathVariable String productId) {
		return (ResponseEntity<T>) ResponseEntity.ok(this.productService.deleteProduct(productId));
	}
	
	// GET ALL
	@GetMapping("/get-all")
	public ResponseEntity<T> getAllProducts() {
		T allProducts = this.productService.getAllProducts();
		return (ResponseEntity<T>) ResponseEntity.ok(allProducts);
	}
	
	// GET BY ID
	@GetMapping("/get/{productId}")
	public ResponseEntity<T> getProductById(@PathVariable String productId) {
		return (ResponseEntity<T>) ResponseEntity.ok(this.productService.getProductById(productId));
	}
	
	// GET PRODUCT BY USERID
	@GetMapping("/get/user/{userId}")
	public ResponseEntity<List<ProductResponseDto>> getProductByUserId(@PathVariable String userId) {
		return  ResponseEntity.ok(this.productService.getProductByUserId(userId));
	}
	 
	
}
