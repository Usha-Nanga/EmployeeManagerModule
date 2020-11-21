package com.tca.time.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.tca.time.model.Manager;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ManagerRepositoryTest {
	  @Autowired
	    private ManagerRepository ManagerRepository;

	    @Autowired
	    private TestEntityManager testEntityManager;
	    

	    @Test
	    public void testCreateManager() throws Exception{
	        Manager manager=new Manager(0,"JIO","abcd@gmail.com","9701531212");
	        Manager savedManager=ManagerRepository.save(manager);
	        assertNotNull(savedManager);
	    }
	    
	    
	    @Test
	    public void testDeleteManager() throws Exception{
	    	 Manager manager1=new Manager(1,"ABAC","abcd@gmail.com","9701531212");
	    	 Manager manager2=new Manager(2,"ABAC","abcd@gmail.com","9701531212");
	    	 
	    	 
	    	 Manager manager= testEntityManager.persist(manager1);
	        testEntityManager.persist(manager2);

	        //delete one ticket DB
	        testEntityManager.remove(manager);

	        List< Manager > managers= (List< Manager >)  ManagerRepository.findAll();
	  	  
	        Assert.assertEquals(managers.size(), 1);

	    }
	    @Test
	    public void testGetAllManagers() throws Exception{
	    	Manager manager1=new Manager();
	    	manager1.setManagerId(1);
	    	manager1.setManagerName("MARINA");
	    	manager1.setManagerEmail("marinas@gmail.com");
	    	manager1.setManagerPhone("08512");
	    	
	    	Manager manager2=new Manager();
	    	manager2.setManagerId(0);
	    	manager2.setManagerName("MARINA");
	    	manager2.setManagerEmail("marinas@gmail.com");
	    	manager2.setManagerPhone("08512");
	    	
	    	 testEntityManager.persist(manager1);
	    	 testEntityManager.persist(manager2);
	    	 
	    	 //Retrieve all managers
		     
	    	 List<Manager> managerlist = (List<Manager>)ManagerRepository.findAll();
		        Assert.assertEquals(2, managerlist.size());
	    }
	    @Test
	    public void testUpdateManager(){

	    	Manager manager2=new Manager();
	    	manager2.setManagerId(0);
	    	manager2.setManagerName("MARINA");
	    	manager2.setManagerEmail("marinas@gmail.com");
	    	manager2.setManagerPhone("08512");
	    	
	    	 testEntityManager.persist(manager2);
	    	 Manager  getFromDb =ManagerRepository.findById(0).get();
	    	 getFromDb.setManagerId(1);
	    	 testEntityManager.persist(getFromDb);
	    	 
	    	 assertThat(getFromDb.getManagerId()).isEqualTo(1);
	    }

}
