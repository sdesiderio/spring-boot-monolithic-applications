package com.example.controller;

import com.example.entity.Customer;
import com.example.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/api/customers")
public class CustomerProductController {
	
	@Autowired
	private CustomerProductService customerProductService;

    @GetMapping("/id/{id}")
    public List<Customer> findAllCustomersByProduct(@PathVariable Integer id){
    	
    	return customerProductService.findAllCustomersByProduct(id);
    	
    }
    
   

}
