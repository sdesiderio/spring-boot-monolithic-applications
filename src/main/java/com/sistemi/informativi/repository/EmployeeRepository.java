package com.sistemi.informativi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sistemi.informativi.document.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String>{
	
	public List<Employee> findByLevel(int level);

}
