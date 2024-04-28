package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface CustomerProductService {
	
	public List<Product> findAllProductsByCustomer(int customerId);
	
	public List<Product> findAllProductsByPriceGreaterThan(double price);
	
	public List<Product> findAllProducts();

}
