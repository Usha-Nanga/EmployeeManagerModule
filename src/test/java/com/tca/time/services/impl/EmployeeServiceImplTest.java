package com.tca.time.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tca.time.model.Employee;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.services.EmployeeService;

class EmployeeServiceImplTest {
	@MockBean
    private EmployeeRepository employeeRepository;
	@Autowired
	  private EmployeeService employeeService;
	@Test
	  public void testCreateEmployee() throws Exception{
		  Employee employee=new Employee();
	    	employee.setEmployeeId(3);
	    	employee.setEmployeeName("amrutha");
	    	employee.setEmployeeEmail("amrutha@gmail.com");
	    	employee.setEmployeePhone("9550355319");
	    	 Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	    	 assertThat(employeeService.createEmployee(employee)).isEqualTo(employee);
	  }
	@Test
    public void testGetAllEmployees() throws Exception{
    	Employee employee1=new Employee();
    	employee1.setEmployeeId(1);
    	employee1.setEmployeeName("amrutha");
    	employee1.setEmployeeEmail("amrutha@gmail.com");
    	employee1.setEmployeePhone("9701531212");

    	Employee employee2=new Employee();
    	employee2.setEmployeeId(2);
    	employee2.setEmployeeName("amrutha");
    	employee2.setEmployeeEmail("amrutha@gmail.com");
    	employee2.setEmployeePhone("9701531212");


        List<Employee> employeelist = new ArrayList<>();
        employeelist.add(employee1);                             
        employeelist.add(employee2);                     
        
        Mockito.when(employeeRepository.findAll()).thenReturn(employeelist);  
        assertThat(employeeService.getAllEmployee()).isEqualTo(employeelist);
    }
	@Test
    public void testDeleteEmployee() throws Exception{
	  
	  Employee employee=new Employee();
    	employee.setEmployeeId(2);
    	employee.setEmployeeName("amrutha");
    	employee.setEmployeeEmail("amrutha@gmail.com");
    	employee.setEmployeePhone("9701531212");
    	 employeeRepository.deleteById(employee.getEmployeeId());
    	 System.out.println(employeeRepository.findById(2));
    	 Assert.assertTrue(employeeRepository.findById(2).isEmpty());                
    }
	@Test
	public void testUpdateEmployee() throws Exception{
		Employee employee2=new Employee();
    	employee2.setEmployeeId(6);
    	employee2.setEmployeeName("amrutha");
    	employee2.setEmployeeEmail("amrutha@gmail.com");
    	employee2.setEmployeePhone("9701531212");
    	
    	  Mockito.when(employeeRepository.save(employee2)).thenReturn(employee2);
    	  Mockito.when(employeeRepository.findById(6).get()).thenReturn(employee2);
    	  
    	  Assert.assertTrue(employeeRepository.findById(6).isEmpty());
  
}
}
