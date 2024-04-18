package com.sistemi.informativi;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;
import com.sistemi.informativi.repository.ProductCustomerRepository;




@SpringBootApplication
public class SbJpaCrudManyToManyApplication implements CommandLineRunner{
	
	// CONSTRUCTOR INJECTION
	private ProductCustomerRepository productCustomerRepository;

	public SbJpaCrudManyToManyApplication(ProductCustomerRepository productCustomerRepository) {
		
		this.productCustomerRepository = productCustomerRepository;
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(SbJpaCrudManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product product1 = new Product("PC","USA");
		Product product2 = new Product("LAPTOP","KOREA");
		
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		
		Customer customer1 = new Customer("Mario","Rossi");
		Customer customer2 = new Customer("Giulio","Verdi");
		
		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);
		
		product1.setCustomers(customers);
		product2.setCustomers(customers);
	    customer1.setProducts(products);
		customer2.setProducts(products);
		
		productCustomerRepository.addProduct(product1);
		productCustomerRepository.addProduct(product2);
		productCustomerRepository.addCustomer(customer1);
		productCustomerRepository.addCustomer(customer2);
		
		productCustomerRepository.findAllProductsByCustomer(1).forEach(element->System.out.println(element));
		productCustomerRepository.findAllCustomersByProduct(1).forEach(element->System.out.println(element));
		
		
		
		
		
	}

	
}
