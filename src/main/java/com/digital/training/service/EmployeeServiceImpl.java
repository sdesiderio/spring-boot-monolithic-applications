package com.digital.training.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.training.entity.Employee;
import com.digital.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveOrUpdateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee removeEmployee(String passportNumber) {
		
		employeeRepository.deleteById(passportNumber);
		
		return new Employee("Cancellazione OK");
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return employeeRepository.findAll();
	}
	
	

}
