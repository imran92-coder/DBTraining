package com.hcl.springboot.traning.service;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.springboot.traning.entity.Employee;
import com.hcl.springboot.traning.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
class EmployeeServiceTest2 {

	private static final Employee EmployeeDto = null;

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	void testGetEmployeeForPagination() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchEmployees() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchEmployeesByName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setEmployeeName("imran");
		employee.setEmail("imran@123");
		employee.setPassword("imran");

		// Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		// employeeRepository.save(employee);
		Mockito.when(employeeRepository.delete(employee)).thenReturn(employee);
		employeeRepository.delete(employee);

		/*
		 * doNothing().when(employeeRepository).delete(); //
		 * Mockito.mock(EmployeeRepository.class); // Act
		 * employeeService.deleteEmployee(5); // Assert // verify(employeeRepository,
		 * times(1)).delete(1);
		 */

		Assert.assertNotNull(employee);
		Assert.assertEquals("Imran", employee.getEmployeeName());

	}

	@Test
	void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

}
