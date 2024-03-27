package com.example.Product.responsitory;

import org.springframework.stereotype.Repository;

import com.example.Product.entity.Product;
import com.example.Product.entity.User;


@Repository
public class OrderResponsitory {
	
	private Product product;
	private User user;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
