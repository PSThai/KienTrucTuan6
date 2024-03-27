package com.example.Product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product.entity.Product;
import com.example.Product.responsitory.ProductResponsitory;

@Service
public class ProductServiceIml implements ProductService{

	@Autowired
	ProductResponsitory productReponsitory;

	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		products = productReponsitory.findAll();
		return products;
	}

	
	public void addProducts(Product product) {
		productReponsitory.save(product);

	}
}
