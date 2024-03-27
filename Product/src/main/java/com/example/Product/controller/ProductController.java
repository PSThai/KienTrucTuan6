package com.example.Product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Product.entity.Product;
import com.example.Product.entity.User;
import com.example.Product.responsitory.OrderResponsitory;
import com.example.Product.responsitory.ProductResponsitory;
import com.example.Product.service.ProductService;

@RestController
@RequestMapping("/api/v2")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ProductResponsitory productReponsitory;

	// Lấy danh sách sản phẩm
	@GetMapping("/get")
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	// Thêm mới sản phẩm
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		productService.addProducts(product);
		return product;
	}

	// Lấy thong tin người dùng và product
	@GetMapping("/orderproduct/{id}/{productId}")
	public ResponseEntity<OrderResponsitory> orderProductByUser(@PathVariable Integer id,
			@PathVariable Integer productId) {
		OrderResponsitory orderResponsitory = new OrderResponsitory();
		String url = "http://localhost:8802/api/v1/get/" + id;
		ResponseEntity<User> reponse = restTemplate.getForEntity(url, User.class);
		Optional<Product> optional = productReponsitory.findById(productId);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			new RuntimeException("Khong co user theo id này");
		}
		User user = reponse.getBody();
		orderResponsitory.setUser(user);
		orderResponsitory.setProduct(product);
		return new ResponseEntity<OrderResponsitory>(orderResponsitory, HttpStatus.OK);
	}
}
