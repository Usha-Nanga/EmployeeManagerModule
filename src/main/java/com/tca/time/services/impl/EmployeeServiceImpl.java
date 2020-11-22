package com.tca.time.services.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Employee;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.services.EmployeeService;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	 public Employee createEmployee( Employee employee) {
			return  employeeRepository.save(employee);
		}
	 
	 public Employee updateEmployee( Integer employeeId,
			 Employee employeeDetails){
		Employee employee = employeeRepository.findById(employeeId).get();
		employee.setEmployeeId(employeeDetails.getEmployeeId());
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
		employee.setEmployeePhone(employeeDetails.getEmployeePhone());
	return  employeeRepository.save(employee);

		
	}
	 
	 public boolean deleteEmployee(Integer employeeId)
				throws ResourceNotFoundException {
		 Employee employee = employeeRepository.findById(employeeId).get();

			employeeRepository.delete(employee);
			return true;
	}
	 
	 public List<Employee> getAllEmployee() {
			return employeeRepository.findAll();
		} 

	
}
