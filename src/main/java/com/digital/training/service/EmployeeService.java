package com.digital.training.service;

import java.util.List;
import java.util.Map;

import com.digital.training.entity.Employee;

public interface EmployeeService {
	
	public Employee saveOrUpdateEmployee(Employee employee);
	
	public Employee removeEmployee(String passportNumber);
	
	public List<Employee> findAllEmployees();
	
	

}
