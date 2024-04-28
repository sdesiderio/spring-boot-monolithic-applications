package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Cacheable(value="EmployeeCache",condition="#experienceYears > 9")
	@Override
	public List<Employee> findByExperienceYears(int experienceYears) {
		
		return employeeRepository.findByExperienceYears(experienceYears);
	}

}
