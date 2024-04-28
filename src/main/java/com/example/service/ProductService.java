package com.example.service;

import java.util.List;



import com.example.entity.Product;


public interface ProductService {
	
    public List<Product> findAllProductsByCustomer(int customerId);
    
    public List<Product> findProductByPriceGreaterThan(double price);
    
    public List<Product> findAllProducts();
    
    public void removeProduct(int productId);
   
}
