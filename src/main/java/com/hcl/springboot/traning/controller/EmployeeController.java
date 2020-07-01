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
import com.hcl.springboot.traning.dto.EmployeeResponseDto;
import com.hcl.springboot.traning.entity.Employee;
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

	/*
	 * @GetMapping("/all") public List<Employee> getAllEmployees() { return
	 * employeeService.getAllEmployees(); }
	 */
	@GetMapping("")
	public ResponseEntity<List<EmployeeDto>> getAllUsers(){ 
		List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(employeeDtos, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("") public EmployeeResponseDto getAllUsers1(){ List<EmployeeDto>
	 * EmployeeDtos = employeeService.getAllEmployees(); EmployeeResponseDto
	 * employeeResponseDto = new EmployeeResponseDto();
	 * employeeResponseDto.setEmployeeDtos(EmployeeDtos);
	 * employeeResponseDto.setStatusCode(200);
	 * employeeResponseDto.setStatusMessage("Success"); return employeeResponseDto;
	 * }
	 */

	/*
	 * @PostMapping("/save") public String registration(@RequestBody Employee
	 * employee) { employeeService.saveEmployee(employee); return
	 * "Data Successfully save"; }
	 */
	@PostMapping("")
	public ResponseEntity<String> registration(@RequestBody EmployeeReqDto userReqDto){ 
		employeeService.saveEmployee(userReqDto);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password) {
		Employee employee = employeeService.login(userName, password);
		if (employee == null) {
			return "Fail to Login";
		}
		return "Login Successfully";
	}

	/*
	 * @GetMapping("/{id}") public Employee getById(@PathVariable Integer id) {
	 * return employeeService.getById(id); }
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable Integer id){ 
		EmployeeDto employeeDto = employeeService.getById(id);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public String updateUser(@PathVariable Integer id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Integer id) {
		return employeeService.deleteEmployee(id);
	}
}
