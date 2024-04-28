package com.digital.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.training.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
