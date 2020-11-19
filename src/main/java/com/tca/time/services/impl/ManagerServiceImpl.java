package com.tca.time.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Manager;
import com.tca.time.repository.ManagerRepository;
import com.tca.time.services.ManagerService;




@Service
@Transactional
public class ManagerServiceImpl  implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	
	 public Manager createManager( @RequestBody Manager manager) {
			return  managerRepository.save(manager);
		}
	 
	 public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") Integer managerId,
			 @RequestBody Manager managerDetails) throws ResourceNotFoundException {
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Company Manager not found for this id :: " + managerId));
		manager.setManagerId(managerDetails.getManagerId());
		manager.setManagerName(managerDetails.getManagerName());
		manager.setManagerEmail(managerDetails.getManagerEmail());
		manager.setManagerPhone(managerDetails.getManagerPhone());
		final Manager updatedManager = managerRepository.save(manager);
		return ResponseEntity.ok(updatedManager); 
		
	}
	 
	 public boolean deleteManager(@PathVariable(value = "id") Integer managerId)
				throws ResourceNotFoundException {
		 Manager manager = managerRepository.findById(managerId)
					.orElseThrow(() -> new ResourceNotFoundException(" Manager not found for this id :: " + managerId));

			managerRepository.delete(manager);
			return true;
	}
	 
	 public List<Manager> getAllManager() {
			return managerRepository.findAll();
		} 
	
	
}
