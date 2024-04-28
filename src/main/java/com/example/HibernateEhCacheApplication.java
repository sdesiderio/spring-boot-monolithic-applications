package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.entity.Customer;
import com.example.entity.Product;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;

@SpringBootApplication
@EnableCaching
public class HibernateEhCacheApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateEhCacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer1 = new Customer("John Legend");
		
		customerRepository.save(customer1);
		
		Product product1 = new Product("product1",1200.89);
		Product product2 = new Product("product2",1300.87);
		
		product1.setCustomer(customer1);
		product2.setCustomer(customer1);
		
		productRepository.save(product1);
		productRepository.save(product2);
		
		
	}

}
