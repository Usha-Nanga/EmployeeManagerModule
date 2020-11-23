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
import com.tca.time.model.Manager;
import com.tca.time.services.ManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="ManagerController",description="REST Apis related to Manager Entity!!!")
@RestController
@RequestMapping("/api/v2")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@ApiOperation(value ="Adding a new Manager to the System",response=Manager.class,tags="ManagerController")
	@PostMapping("/CreateManager")
	public Manager createManger( @RequestBody Manager manager) {
		return managerService.createManager(manager);
	} 
	@ApiOperation(value ="Updating the Manager info in the System by id",response=Manager.class,tags="ManagerController")
	@PutMapping("/Manager/{id}")
	public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") Integer managerId,
			 @RequestBody Manager managerDetails) throws ResourceNotFoundException {
		Manager manager = managerService.updateManager(managerId, managerDetails);
		return  ResponseEntity.ok(manager);
	}

	@ApiOperation(value ="Deleting the Manager by ID in the System",response=Manager.class,tags="ManagerController")
	@DeleteMapping("/Manager/{id}")	
	public ResponseEntity<Boolean> deleteManager(@PathVariable(value = "id") Integer managerId) throws ResourceNotFoundException	{
		
		boolean manager = managerService.deleteManager(managerId);
		return  ResponseEntity.ok(manager);
	}
	@ApiOperation(value ="Get List of Managers from the System",response=Manager.class,tags="ManagerController")
	@GetMapping("/Manager")
	public List<Manager> getAllManager() {
		return managerService.getAllManager();
	} 
	
}
