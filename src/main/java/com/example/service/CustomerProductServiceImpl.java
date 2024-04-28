package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.ProductRepository;

@Service
@CacheConfig(cacheNames="customers")
public class CustomerProductServiceImpl implements CustomerProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Cacheable(key="#id")
	@Override
	public List<Customer> findAllCustomersByProduct(Integer id) {
		
		return productRepository.findById(id).get().getCustomers();
	}

}
