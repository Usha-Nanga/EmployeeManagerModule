package com.tca.time.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.tca.time.model.Employee;
@RunWith(SpringRunner.class)
@DataJpaTest
class EmployeeRepositoryTest {
	@Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager testEntityManager;
	 @Test
	    void testNewEmployee() throws Exception{
	    	Employee employee= new Employee();
	    	employee.setEmployeeId(3);
	    	employee.setEmployeeName("amrutha");
	    	employee.setEmployeeEmail("ammu@gmail.com");
	    	employee.setEmployeePhone("9550355319");
	    	Employee saveInDb=testEntityManager.persist(employee);
	    	Employee getFromInDb= employeeRepository.findById(saveInDb.getEmployeeId()).get();
	    	 assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 @Test
	     void testGetAllEmployees() throws Exception{
	    	Employee employee1=new Employee();
	    	employee1.setEmployeeId(3);
	    	employee1.setEmployeeName("amrutha");
	    	employee1.setEmployeeEmail("ammu@gmail.com");
	    	employee1.setEmployeePhone("9550355319");

	    	Employee employee2=new Employee();
	    	employee2.setEmployeeId(1);
	    	employee2.setEmployeeName("amrutha");
	    	employee2.setEmployeeEmail("ammu@gmail.com");
	    	employee2.setEmployeePhone("9550355319");

	        //Save into in memory database
	        testEntityManager.persist(employee1);
	        testEntityManager.persist(employee2);

	        //Retrieve all employees
	     
	        List<Employee> employeelist = (List<Employee>)employeeRepository.findAll();
	        Assert.assertEquals(2, employeelist.size());
	    }

	 @Test
	     void testUpdateEmployee(){

	    	Employee employee2=new Employee();
	    	employee2.setEmployeeId(1);
	    	employee2.setEmployeeName("amrutha");
	    	employee2.setEmployeeEmail("ammu@gmail.com");
	    	employee2.setEmployeePhone("9550355319");

	    	
	    	 testEntityManager.persist(employee2);
	    	 Employee  getFromDb =employeeRepository.findById(1).get();
	    	 getFromDb.setEmployeeId(2);
	    	 testEntityManager.persist(getFromDb);
	    	 
	    	 assertThat(getFromDb.getEmployeeId()).isEqualTo(2);
	    }
	 @Test
     void testDeleteEmployee() throws Exception{
 	Employee employee1=new Employee();
 	employee1.setEmployeeId(3);
 	employee1.setEmployeeName("amrutha");
 	employee1.setEmployeeEmail("ammu@gmail.com");
 	employee1.setEmployeePhone("9550355319");

 	Employee employee2=new Employee();
 	employee2.setEmployeeId(1);
 	employee2.setEmployeeName("amrutha");
 	employee2.setEmployeeEmail("ammu@gmail.com");
 	employee2.setEmployeePhone("9550355319");

 	Employee employee=testEntityManager.persist(employee1);
 	 testEntityManager.persist(employee2);
 	 
 	//delete one ticket DB
	     testEntityManager.remove(employee);
	        

	    List<Employee> employees = (List<Employee>)employeeRepository.findAll();
	    Assert.assertEquals(employees.size(), 1);      

 }  

}
