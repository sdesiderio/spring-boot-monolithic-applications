package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Cacheable(value="EmployeeCache", condition = "#experienceYears > 9")
	public List<Employee> findByExperienceYears(int experienceYears) {
		
		return employeeRepository.findByExperienceYears(experienceYears);
	}

	@Cacheable("EmployeeCache")
	@Override
	public List<Employee> findByExperienceYearsGreaterThan(int experienceYears) {
		
		return employeeRepository.findByExperienceYears(experienceYears);
	}
	
	@CacheEvict(condition = "#experienceYears > 9")
	@Override
    public void removeEmployee(int employeeId) {
		
        
    }

}
