package com.tca.time.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Employee;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.services.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee createEmployee( @RequestBody Employee employee) {
		return  employeeRepository.save(employee);
	}	

 public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
		 @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
	Employee employee = employeeRepository.findById(employeeId)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	employee.setEmployeeId(employeeDetails.getEmployeeId());
	employee.setEmployeeName(employeeDetails.getEmployeeName());
	employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
	employee.setEmployeePhone(employeeDetails.getEmployeePhone());
	final Employee updatedEmployee = employeeRepository.save(employee);
	return ResponseEntity.ok(updatedEmployee); 
} 
 
 public boolean deleteEmployeeById(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
	 Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		return true;
}

 public List<Employee> getAllEmployee() {
		 return employeeRepository.findAll();
		}

	
}
