package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.entity.Product;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;

@Service
@CacheConfig(cacheNames="products")
public class CustomerProductServiceImpl implements CustomerProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
    @Cacheable(key="#customerId")
	@Override
	public List<Product> findAllProductsByCustomer(int customerId) {
		
		Customer customer = customerRepository.findById(customerId).get();
		
		return productRepository.findByCustomer(customer);
		
		
	}

    @Cacheable(key="#price")
	@Override
	public List<Product> findAllProductsByPriceGreaterThan(double price) {
		
		return productRepository.findByPriceGreaterThan(price);
	}

    @Cacheable
	@Override
	public List<Product> findAllProducts() {
		
		return productRepository.findAll();
	}

}
