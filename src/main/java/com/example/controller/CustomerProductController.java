package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.CustomerProductService;

@RestController
@RequestMapping("/rest/api/products")
public class CustomerProductController {
	
	@Autowired
	private CustomerProductService customerProductService;
	
	@GetMapping("/customer-id/{customerId}")
	public List<Product> findAllProductsByCustomer(@PathVariable int customerId){
		
		return customerProductService.findAllProductsByCustomer(customerId);
	}
	
	@GetMapping("/price/{price}")
	public List<Product> findAllProductsByPriceGreaterThan(@PathVariable double price){
		
		return customerProductService.findAllProductsByPriceGreaterThan(price);
		
		
	}
	
	@GetMapping
	public List<Product> findAllProducts(){
		
		return customerProductService.findAllProducts();
		
	}
	

}
