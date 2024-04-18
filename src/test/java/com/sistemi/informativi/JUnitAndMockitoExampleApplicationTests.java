package com.sistemi.informativi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sistemi.informativi.document.Employee;
import com.sistemi.informativi.repository.EmployeeRepository;
import com.sistemi.informativi.service.EmployeeService;

@SpringBootTest
class JUnitAndMockitoExampleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository userRepository;

	@Test
	public void testFindByUsername() {

		int level = 5;

		Employee employee1 = new Employee("1056A", "myname1", 5);
		Employee employee2 = new Employee("1056B", "myname2", 5);

		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);

		Mockito.when(userRepository.findByLevel(level)).thenReturn(employees);

		// When
		List<Employee> mockEmployees = employeeService.findAllEmployeesByLevel(level);

		// Then
		assertNotNull(mockEmployees);
		assertEquals(mockEmployees.size(), 2);
	}

}
