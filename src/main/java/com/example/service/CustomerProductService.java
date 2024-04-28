package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerProductService {
	
	public List<Customer> findAllCustomersByProduct(Integer id);

}
