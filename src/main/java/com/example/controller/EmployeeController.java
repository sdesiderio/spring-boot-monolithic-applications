package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/experience-years/{experienceYears}")
	public List<Employee> findByExperienceYears(@PathVariable int experienceYears){
		
		return employeeService.findByExperienceYears(experienceYears);
		
	}

}
