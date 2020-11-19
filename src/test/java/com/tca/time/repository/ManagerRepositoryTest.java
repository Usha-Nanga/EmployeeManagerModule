package com.tca.time.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
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

import com.tca.time.model.Employee;
import com.tca.time.model.Manager;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.repository.ManagerRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ManagerRepositoryTest {
	  @Autowired
	    private ManagerRepository ManagerRepository;
	  
	  @Autowired
	    private EmployeeRepository employeeRepository;

	    @Autowired
	    private TestEntityManager testEntityManager;
	    

	    @Test
	    public void testCreateManager() throws Exception{
	        Manager manager=new Manager(0,"JIO","abcd@gmail.com","9701531212");
	        Manager savedManager=ManagerRepository.save(manager);
	        assertNotNull(savedManager);
	    }
	    
	    @Test
	    public void testEmployee() throws Exception{
	        Employee employee=new Employee(1,"ammu","amrutha@gmail.com","9701531212");
	        Employee savedEmployee=employeeRepository.save(employee);
	        assertNotNull(savedEmployee);

	    }
	    
	    @Test
	    public void testDeleteEmployee() throws Exception{
	    	 Employee employee1=new Employee(1,"ammu","amrutha@gmail.com","9701531212");
	    	 Employee employee2=new Employee(2,"ammu","amrutha@gmail.com","9701531212");
	    	 
	    	 
	   
	        Employee employee = testEntityManager.persist(employee1);
	        testEntityManager.persist(employee2);

	        //delete one ticket DB
	        testEntityManager.remove(employee);

	        List<Employee> employees = (List<Employee>)  employeeRepository.findAll();
	        Assert.assertEquals(employees.size(), 1);

	    }
	    
	    @Test
	    public void testDeleteManager() throws Exception{
	    	 Manager manager1=new Manager(1,"JIO","abcd@gmail.com","9701531212");
	    	 Manager manager2=new Manager(2,"JIO","abcd@gmail.com","9701531212");
	    	 
	    	 
	    	 Manager manager= testEntityManager.persist(manager1);
	        testEntityManager.persist(manager2);

	        //delete one ticket DB
	        testEntityManager.remove(manager);

	        List< Manager > managers= (List< Manager >)  ManagerRepository.findAll();
	  	  
	        Assert.assertEquals(managers.size(), 1);

	    }
	    
	 /*   @Test
	    public void testUpdateManager(){
	    	 Manager manager2=new Manager(1,"JIO","abc@gmail.com","9701531212");
	    	 
	       
	    	 testEntityManager.persist(manager2);
	    	 Manager  getFromDb =ManagerRepository.findByEmail("abc@gmail.com");
	    	 getFromDb.setManagerEmail("bac@gmail.com");
	         testEntityManager.persist(getFromDb);

	         assertThat(getFromDb.getManagerEmail()).isEqualTo("bac@gmail.com");
	     
	    }*/


}
