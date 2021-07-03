package com.hcl.springboot.traning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springboot.traning.dto.EmployeeDto;
import com.hcl.springboot.traning.dto.EmployeeReqDto;
import com.hcl.springboot.traning.entity.Employee;
import com.hcl.springboot.traning.exception.EmployeeNotFoundException;
import com.hcl.springboot.traning.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/pagination")
	public List<Employee> getEmployeeForPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return employeeService.getEmployeeForPagination(pageNumber, pageSize);
	}

	@GetMapping("/EXsearch")
	public List<Employee> searchEmployeesByName(@RequestParam String employeeName) {
		return employeeService.searchEmployeesByName(employeeName);
	}

	@GetMapping("/search")
	public List<Employee> searchEmployees(@RequestParam String employeeName) {
		return employeeService.searchEmployees(employeeName);
	}

	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(employeeDtos, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> registration(@RequestBody EmployeeReqDto employeeReqDto) {
		employeeService.saveEmployee(employeeReqDto);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public String login(@RequestParam String employeeName, @RequestParam String password) {
		Employee employee = employeeService.login(employeeName, password);
		if (employee == null) {
			return "Fail to Login";
		}
		return "Login Successfully";
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable Integer id) throws EmployeeNotFoundException {
		EmployeeDto employeeDto = employeeService.getById(id);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Integer id) {
		return employeeService.deleteEmployee(id);
	}
}
