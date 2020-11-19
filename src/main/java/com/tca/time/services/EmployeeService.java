package com.tca.time.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);	
	ResponseEntity<Employee> updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException;
	boolean deleteEmployeeById(Integer employeeId) throws ResourceNotFoundException;
	List<Employee> getAllEmployee();

}
