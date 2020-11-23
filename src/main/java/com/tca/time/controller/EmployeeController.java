package com.tca.time.controller;

import java.util.List;

//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponses;
@Api(value="EmployeeController",description="REST Apis related to Employee Entity!!!")
@RestController
@RequestMapping("/api/v2")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@ApiOperation(value ="Adding a new Employee in the System",response=Employee.class,tags="EmployeeController")
	@PostMapping("/CreateEmployee")
	public Employee createEmployee( @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	} 
	@ApiOperation(value ="Updating Employee information by id",response=Employee.class,tags="EmployeeController")
	@PutMapping("/Employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			 @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeService.updateEmployee(employeeId, employeeDetails);
		return  ResponseEntity.ok(employee);
	}

	@ApiOperation(value ="Deleting the Employee in the System by id",response=Employee.class,tags="EmployeeController")
	@DeleteMapping("/Employee/{id}")	
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId) throws ResourceNotFoundException	{
		
		boolean employee = employeeService.deleteEmployee(employeeId);
		return  ResponseEntity.ok(employee);
	}
	@ApiOperation(value ="Get list of Employees in the System",response=Iterable.class,tags="EmployeeController")
//	@ApiResponses(value= {
//			@ApiResponse(code=200,message="Success|OK"),
//			@ApiResponse(code=401,message="not Authorized!"),
//			@ApiResponse(code=403,message="forbidden!"),
//			@ApiResponse(code=404,message="not found!!!")	
//	})
	@GetMapping("/Employee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	} 
}
