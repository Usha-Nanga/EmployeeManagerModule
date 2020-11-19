package com.tca.time.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.tca.time.model.Manager;
import com.tca.time.repository.ManagerRepository;
import com.tca.time.services.ManagerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceImplTest {
	
	@MockBean
    private ManagerRepository managerRepository;
	
	  @Autowired
	  private ManagerService managerService;
	  
	  @Test
	    public void testCreateManager() throws Exception{
		  Manager manager=new Manager();
	    	manager.setManagerId(1);
	    	manager.setManagerName("MARINA");
	    	manager.setManagerEmail("mainas@gmail.com");
	    	manager.setManagerPhone("085126767");
	    	 Mockito.when(managerRepository.save(manager)).thenReturn(manager);
	    	 assertThat(managerService.createManager(manager)).isEqualTo(manager);               
	    }
	  
	  @Test
	    public void testGetAllManager() throws Exception{
		  Manager manager1=new Manager();
	    	manager1.setManagerId(1);
	    	manager1.setManagerName("MARINA");
	    	manager1.setManagerEmail("marinas@gmail.com");
	    	manager1.setManagerPhone("0851235353");
	    	
	    	Manager manager2=new Manager();
	    	manager2.setManagerId(0);
	    	manager2.setManagerName("MARINA");
	    	manager2.setManagerEmail("marinas@gmail.com");
	    	manager2.setManagerPhone("0851235353");
	    	

	        List<Manager> managerlist = new ArrayList<>();
	        managerlist.add(manager1);
	        managerlist.add(manager2);
	        
	        Mockito.when(managerRepository.findAll()).thenReturn(managerlist);  
	        assertThat(managerService.getAllManager()).isEqualTo(managerlist);
	    	
	  }  
	  @Test
	    public void testDeleteManagerById() throws Exception{
		  Manager manager=new Manager();
	    	manager.setManagerId(1);
	    	manager.setManagerName("MARINA");
	    	manager.setManagerEmail("marinas@gmail.com");
	    	manager.setManagerPhone("085123433");
	    	managerRepository.deleteById(manager.getManagerId());
	    	System.out.println(managerRepository.findById(1));
	    	 Assert.assertTrue(managerRepository.findById(1).isEmpty());    
	  }  
	@Test
	public void testUpdateManagerById() throws Exception{
		Manager manager=new Manager();
    	manager.setManagerId(1);
    	manager.setManagerName("MARINA");
    	manager.setManagerEmail("marinas@gmail.com");
    	manager.setManagerPhone("0851223243");
    	
    	System.out.println( Mockito.when(managerRepository.save(manager)).thenReturn(manager));
    	  manager.setManagerEmail("amrutha@gmail.com");
    	  
     	 System.out.println(manager.getManagerEmail());
     	 System.out.println( Mockito.when(managerRepository.findById(3).get()).thenReturn(manager));
 
	}  
	
	  
	
	  
	 
}
