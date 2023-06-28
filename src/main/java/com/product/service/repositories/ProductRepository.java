package com.product.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.service.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByUserId(String userId);
}
