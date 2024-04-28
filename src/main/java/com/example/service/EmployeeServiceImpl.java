package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
@CacheConfig(cacheNames="employees")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Cacheable(value="employees", condition = "#experienceYears > 9")
	@Override
	public List<Employee> findEmployeesByExperienceYears(int experienceYears) {
		
		System.out.println("findEmployeesByExperienceYears");
		
		return employeeRepository.findByExperienceYears(experienceYears);
	}

	@Cacheable("employees")
	@Override
	public List<Employee> findEmployeesByExperienceYearsGreaterThan(int experienceYears) {
		
		System.out.println("findEmployeesByExperienceYearsGreaterThan");
		
		return employeeRepository.findByExperienceYearsGreaterThan(experienceYears);
	}

}
