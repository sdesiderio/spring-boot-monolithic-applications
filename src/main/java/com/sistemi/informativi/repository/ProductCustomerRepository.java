package com.sistemi.informativi.repository;

import java.util.List;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;

public interface ProductCustomerRepository {
	
	public void addProduct(Product product);
	
	public void addCustomer(Customer customer);
	
	public List<Product> findAllProductsByCustomer(int customerId);
	
	public List<Customer> findAllCustomersByProduct(int productId);
	

}
