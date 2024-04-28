package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/rest/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/customer-id/{customerId}")
	public List<Product> findAllProductsByCustomer(@PathVariable int customerId) {
		
		return productService.findAllProductsByCustomer(customerId);

	}

	@GetMapping("/price/{price}")
	public List<Product> findProductByPriceGreaterThan(@PathVariable double price) {
		
		return productService.findProductByPriceGreaterThan(price);

	}

	@GetMapping("")
	public List<Product> findAllProducts() {
		
		return productService.findAllProducts();

	}
	
	@DeleteMapping("/customer-id/{customerId}")
	public void removeProduct(@PathVariable int customerId) {
		
		
	}

}
