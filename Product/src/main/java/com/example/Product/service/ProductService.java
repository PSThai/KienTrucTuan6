package com.example.Product.service;

import java.util.List;

import com.example.Product.entity.Product;

public interface ProductService {
	List<Product> findAllProducts();

    void addProducts(Product product);
}
