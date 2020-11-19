package com.tca.time.repository;


import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tca.time.model.Manager;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.repository.ManagerRepository;



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
	    

}
