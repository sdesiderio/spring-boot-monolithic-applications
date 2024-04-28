package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
    public List<Employee> findEmployeesByExperienceYears(int experienceYears);
	
	public List<Employee> findEmployeesByExperienceYearsGreaterThan(int experienceYears);
	
	

}
