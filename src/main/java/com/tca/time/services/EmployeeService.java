package com.tca.time.services;

import java.util.List;

import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException;
	boolean deleteEmployee(Integer employeeId) throws ResourceNotFoundException;
	List<Employee> getAllEmployee();
}
