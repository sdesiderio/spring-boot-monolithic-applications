package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.entity.Product;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;

@Service
@CacheConfig(cacheNames="products")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	//SpEl = Spring Expression Language
	@Cacheable(key="#customerId")
	@Override
	public List<Product> findAllProductsByCustomer(int customerId) {

		System.out.println("findAllProductsByCustomer");

		Customer customer = customerRepository.findById(customerId).get();

		return productRepository.findByCustomer(customer);

	}

	@Cacheable(key="#price")
	@Override
	public List<Product> findProductByPriceGreaterThan(double price) {

		System.out.println("findProductByPriceGreaterThan");

		return productRepository.findByPriceGreaterThan(price);

	}

	@Cacheable
	@Override
	public List<Product> findAllProducts() {

		System.out.println("findAllProducts");

		return productRepository.findAll();

	}

	@CacheEvict(allEntries=true, cacheNames={"products"})
	@Override
	public void removeProduct(int productId) {
		
		System.out.println("removeProduct");
		
	}
	
	//@CachePut(key="#x")

}
