package com.tca.time.repository;

import static org.junit.Assert.assertNotNull;
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
    public void testEmployee() throws Exception{
        Employee employee=new Employee(1,"ammu","amrutha@gmail.com","9701545452");
        Employee savedEmployee=employeeRepository.save(employee);
        assertNotNull(savedEmployee);

    }
    
    @Test
    public void testDeleteEmployee() throws Exception{
    	 Employee employee1=new Employee(1,"ammu","amrutha@gmail.com","9701545452");
    	 Employee employee2=new Employee(2,"ammu","amrutha@gmail.com","9701545452");
    	 
    	 
   
        Employee employee = testEntityManager.persist(employee1);
        testEntityManager.persist(employee2);

        //delete one ticket DB
        testEntityManager.remove(employee);

        List<Employee> employees = (List<Employee>)  employeeRepository.findAll();
        Assert.assertEquals(employees.size(), 1);

    }

}
