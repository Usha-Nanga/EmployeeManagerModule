package com.tca.time.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tca.time.model.Employee;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.services.EmployeeService;
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {
	
	@MockBean
    private EmployeeRepository employeeRepository;
	
	  @Autowired
	  private EmployeeService employeeService;
	  
	  @Test
	    public  void testCreateEmployee() throws Exception{
		  Employee employee=new Employee();
	    	employee.setEmployeeId(1);
	    	employee.setEmployeeName("MARINA");
	    	employee.setEmployeeEmail("mainas@gmail.com");
	    	employee.setEmployeePhone("085126767");
	    	 Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	    	 assertThat(employeeService.createEmployee(employee)).isEqualTo(employee);               
	    }
	  
	  @Test
	    public void testGetAllEmployee() throws Exception{
		  Employee employee1=new Employee();
	    	employee1.setEmployeeId(1);
	    	employee1.setEmployeeName("MARINA");
	    	employee1.setEmployeeEmail("marinas@gmail.com");
	    	employee1.setEmployeePhone("0851235353");
	    	
	    	Employee employee2=new Employee();
	    	employee2.setEmployeeId(0);
	    	employee2.setEmployeeName("MARINA");
	    	employee2.setEmployeeEmail("marinas@gmail.com");
	    	employee2.setEmployeePhone("0851235353");
	        List<Employee> employeelist = new ArrayList<>();
	        employeelist.add(employee1);
	        employeelist.add(employee2);
	        
	        Mockito.when(employeeRepository.findAll()).thenReturn(employeelist);  
	        assertThat(employeeService.getAllEmployee()).isEqualTo(employeelist);
	    	
	  }  
	  @Test
	    public void testDeleteEmployee() throws Exception{
		  Employee employee=new Employee();
	    	employee.setEmployeeId(1);
	    	employee.setEmployeeName("MARINA");
	    	employee.setEmployeeEmail("marinas@gmail.com");
	    	employee.setEmployeePhone("085123433");
	    	employeeRepository.deleteById(employee.getEmployeeId());
	    	System.out.println(employeeRepository.findById(1));
	    	 Assert.assertTrue(employeeRepository.findById(1).isEmpty());    
	  }  
	  @Test
		public void testUpdateEmployee() throws Exception{
			Employee employee2=new Employee();
	    	employee2.setEmployeeId(6);
	    	employee2.setEmployeeName("MARINA");
	    	employee2.setEmployeeEmail("marinas@gmail.com");
	    	employee2.setEmployeePhone("0851123433");
	    	
//	    	  Mockito.when(employeeRepository.save(employee2)).thenReturn(employee2);
//	    	  Mockito.when(employeeRepository.findById(0).get()).thenReturn(employee2);
//   	  Mockito.when(employeeRepository.save(employee2)).thenReturn(employee2);
   	  System.out.println(employee2.getEmployeeEmail());
   	employeeRepository.findById(employee2.getEmployeeId());
	System.out.println(employeeRepository.findById(1));
	 Assert.assertTrue(employeeRepository.findById(1).isEmpty()); 
	    	  //Assert.assertTrue(employeeRepository.findById(0).isEmpty());
	 
		}
  
}
