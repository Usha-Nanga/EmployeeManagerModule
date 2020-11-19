package com.tca.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Employee;
import com.tca.time.services.EmployeeService;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/Employee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	} 
	
	@PostMapping("/CreateEmployee")
	public Employee createEmployee( @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	} 
	
	@PutMapping("/Employee/{id}")
	public ResponseEntity<ResponseEntity<Employee>> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			 @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		ResponseEntity<Employee>  employee = employeeService.updateEmployee(employeeId, employeeDetails);
		return  ResponseEntity.ok(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")	
	public boolean deleteEmployeeById(@PathVariable(value = "id") Integer employeeId,
			 @RequestBody Employee employeeDetails) throws ResourceNotFoundException	{
		boolean employee = employeeService.deleteEmployeeById(employeeId);
		return true;
	}  
}