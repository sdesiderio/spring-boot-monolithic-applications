package com.sistemi.informativi.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product implements Serializable{
	

	private static final long serialVersionUID = -7660483640870726024L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String origin;
	
	@ManyToMany(mappedBy="products",fetch=FetchType.EAGER)
	private List<Customer> customers;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	protected Product() {
		
	}

	public Product(String name, String origin) {
		
		this.name = name;
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", origin=" + origin + "]";
	}
	
	
	
	

}
