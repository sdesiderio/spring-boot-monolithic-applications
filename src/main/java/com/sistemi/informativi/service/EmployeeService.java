package com.sistemi.informativi.service;

import java.util.List;

import com.sistemi.informativi.document.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployeesByLevel(int level);
	
	public Employee saveEmployee(Employee employee);

}
