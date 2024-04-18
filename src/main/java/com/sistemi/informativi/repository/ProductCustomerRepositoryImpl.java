package com.sistemi.informativi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class ProductCustomerRepositoryImpl implements ProductCustomerRepository{
	
	@PersistenceContext
	private EntityManager em;
	

	
	@Override
	public void addProduct(Product product) {
		
       em.persist(product);
		
	}

	@Override
	public void addCustomer(Customer customer) {
		
		em.persist(customer);
		
	}

	@Override
	public List<Product> findAllProductsByCustomer(int customerId) {
		
		
		Customer customer = em.find(Customer.class, customerId);
		
		return customer.getProducts();
	}

	@Override
	public List<Customer> findAllCustomersByProduct(int productId) {
		
		Product product = em.find(Product.class, productId);
		
		return product.getCustomers();
		
		
	}

}
