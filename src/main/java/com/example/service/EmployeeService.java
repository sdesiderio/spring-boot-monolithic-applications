package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findByExperienceYears(int experienceYears);
	
	public List<Employee> findByExperienceYearsGreaterThan(int experienceYears);
	
	public void removeEmployee(int employeeId);

}
