package com.tca.time.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.tca.time.model.Manager;
import com.tca.time.services.ManagerService;


@RestController
@RequestMapping("/api/v2")
public class ManagerController {
	private static final Logger logger = LogManager.getLogger(ManagerController.class);
	@Autowired
	private ManagerService managerService;

	@PostMapping("/CreateManager")
	public Manager createManger( @RequestBody Manager manager) {
		return managerService.createManager(manager);
	} 
	
	@PutMapping("/Manager/{id}")
	public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") Integer managerId,
			 @RequestBody Manager managerDetails) throws ResourceNotFoundException {
		Manager manager = managerService.updateManager(managerId, managerDetails);
		return  ResponseEntity.ok(manager);
	}


	@DeleteMapping("/Manager/{id}")	
	public ResponseEntity<Boolean> deleteManager(@PathVariable(value = "id") Integer managerId) throws ResourceNotFoundException	{
		
		boolean manager = managerService.deleteManager(managerId);
		return  ResponseEntity.ok(manager);
	}
	
	@GetMapping("/Manager")
	public List<Manager> getAllManager() {
		return managerService.getAllManager();
	} 
	
}
