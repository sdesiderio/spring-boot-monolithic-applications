package com.digital.training.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.training.entity.Employee;
import com.digital.training.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("")
	public List<Employee> findAllEmployees(){
		
		return employeeService.findAllEmployees();
		
	}
	
	@PostMapping("")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		return employeeService.saveOrUpdateEmployee(employee);
		
	}
	
	
	@PutMapping("")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		return employeeService.saveOrUpdateEmployee(employee);
		
	}
	
	@DeleteMapping("/{passportNumber}")
	public Employee removeEmployee(@PathVariable String passportNumber){
		
		return employeeService.removeEmployee(passportNumber);
		
	}

}
