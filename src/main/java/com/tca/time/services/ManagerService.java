package com.tca.time.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Manager;


public interface ManagerService {
	Manager createManager(Manager manager);
	Manager updateManager(Integer managerId, Manager managerDetails) throws ResourceNotFoundException;
	boolean deleteManager(Integer managerId) throws ResourceNotFoundException;
	List<Manager> getAllManager();

	 
}
