package com.hcl.springboot.traning.service;

import java.util.Optional;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.springboot.traning.dto.EmployeeDto;
import com.hcl.springboot.traning.entity.Employee;
import com.hcl.springboot.traning.exception.EmployeeNotFoundException;
import com.hcl.springboot.traning.repository.EmployeeRepository;


//@RunWith(MockitoJUnitRunner.Silent.class)    //if you want to use un-nessesary stubbing then you can use "silent"
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	
	static Employee employee=null;
	@BeforeClass
	public static void  setup() {
		employee=new Employee();
	}
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Test(expected = EmployeeNotFoundException.class)
	public void testGetByIdForException() throws EmployeeNotFoundException {
		/*
		 * Employee employee=new Employee(); employee.setId(2);
		 * employee.setEmail("imran@123"); employee.setEmployeeName("imran");
		 * employee.setPassword("imran");
		 * Mockito.when(employeeRepository.findById(2)).thenReturn(Optional.of(employee)
		 * );
		 */
		
		EmployeeDto employeeDto=employeeService.getById(3);
		/*
		 * Assert.assertNotNull(employeeDto);
		 * Assert.assertEquals("imran",employeeDto.getEmployeeName() );
		 */
		
		
	}
	
	@Test
	public void testGetByIdForPositive() throws EmployeeNotFoundException {
		employee.setId(2);
		employee.setEmail("imran@123");
		employee.setEmployeeName("imran");
		employee.setPassword("imran");
		
		
		//Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));
		Mockito.when(employeeRepository.findById(2)).thenReturn(Optional.of(employee));
		EmployeeDto employeeDto=employeeService.getById(2);
		Assert.assertNotNull(employeeDto);
		Assert.assertEquals("imran",employeeDto.getEmployeeName() );
		
		
	}
	@Test
	public void testSave() {
		EmployeeDto employeeDto=new EmployeeDto();
		employee.setEmail("imran@123");
		employee.setEmployeeName("imran1");
		employee.setPassword("imran");
		
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		employeeRepository.save(employee);
		Assert.assertNotNull(employee);
		System.out.println(employee.getEmployeeName());
		Assert.assertEquals("imran1",employee.getEmployeeName());
		

	}
	
	@Test
public void testUpdate(){
	EmployeeDto employeeDto=new EmployeeDto();
	employee.setEmail("imran@123");
	employee.setId(1);
	employee.setEmployeeName("imran1");
	employee.setPassword("imran");
	Mockito.when(employeeService.updateEmployee(1, employee));
	//employeeService.updateEmployee(1, employee);
	Assert.assertNotNull(employee);
	System.out.println(employee.getEmployeeName());
	Assert.assertEquals("imran1",employee.getEmployeeName());
	
	
}   @Test
	public void testLoginForPositive() {
	//employee.
		
	}
	
	/*
	 * public void testDeleteEmployeeForPositive() throws EmployeeNotFoundException
	 * { Employee employee=new Employee(); employee.setId(1);
	 * employee.setEmployeeName("imran");
	 * 
	 * Mockito.when(employeeRepository.delete(employee)).thenReturn(employee);
	 * EmployeeDto employeeDto=employeeService.getId();
	 * Assert.assertNotNull(employeeDto);
	 * Assert.assertEquals("imran",employeeDto.getEmployeeName());
	 * 
	 * }
	 */
}
