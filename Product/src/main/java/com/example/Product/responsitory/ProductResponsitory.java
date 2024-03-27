package com.example.Product.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Product.entity.Product;

public interface ProductResponsitory  extends JpaRepository<Product, Integer> {
	
}
