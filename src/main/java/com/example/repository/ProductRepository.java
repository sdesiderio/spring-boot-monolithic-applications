package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customer;
import com.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCustomer(Customer customer);
	
	public List<Product> findByPriceGreaterThan(double price);
	

}
