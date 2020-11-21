package com.tca.time.services.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tca.time.exception.ResourceNotFoundException;
import com.tca.time.model.Manager;
import com.tca.time.repository.ManagerRepository;
import com.tca.time.services.ManagerService;

@Service
@Transactional
public class ManagerServiceImpl  implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	
	 public Manager createManager( Manager manager) {
			return  managerRepository.save(manager);
		}
	 
	 public Manager updateManager( Integer managerId,
			 Manager managerDetails){
		Manager manager = managerRepository.findById(managerId).get();
		manager.setManagerId(managerDetails.getManagerId());
		manager.setManagerName(managerDetails.getManagerName());
		manager.setManagerEmail(managerDetails.getManagerEmail());
		manager.setManagerPhone(managerDetails.getManagerPhone());
		final Manager updatedManager = managerRepository.save(manager);
		return updatedManager; 
		
	}
	 
	 public boolean deleteManager(Integer managerId)
				throws ResourceNotFoundException {
		 Manager manager = managerRepository.findById(managerId).get();

			managerRepository.delete(manager);
			return true;
	}
	 
	 public List<Manager> getAllManager() {
			return managerRepository.findAll();
		} 
	
	
}
