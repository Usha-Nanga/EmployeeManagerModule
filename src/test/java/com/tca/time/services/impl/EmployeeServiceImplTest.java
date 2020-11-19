package com.tca.time.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tca.time.model.Employee;
import com.tca.time.repository.EmployeeRepository;
import com.tca.time.services.EmployeeService;
import com.tca.time.services.ManagerService;

class EmployeeServiceImplTest {
	@MockBean
    private EmployeeRepository employeeRepository;
	@Autowired
	  private EmployeeService employeeService;
	@Test
	  public void testCreateEmployee() throws Exception{
		  Employee employee=new Employee();
	    	employee.setEmployeeId(3);
	    	employee.setEmployeeName("usha");
	    	employee.setEmployeeEmail("ushareddy@gmail.com");
	    	employee.setEmployeePhone("9550355319");
	    	 Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	    	 assertThat(employeeService.createEmployee(employee)).isEqualTo(employee);
	  }
	@Test
    public void testGetAllEmployees() throws Exception{
    	Employee employee1=new Employee();
    	employee1.setEmployeeId(1);
    	employee1.setEmployeeName("usha");
    	employee1.setEmployeeEmail("ushareddy@gmail.com");
    	employee1.setEmployeePhone("9550355319");

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
    public void testDeleteEmployeeById() throws Exception{
	  
	  Employee employee=new Employee();
    	employee.setEmployeeId(2);
    	employee.setEmployeeName("Marina");
    	employee.setEmployeeEmail("marinas@gmail.com");
    	employee.setEmployeePhone("9550355319");
    	 employeeRepository.deleteById(employee.getEmployeeId());
    	 System.out.println(employeeRepository.findById(2));
    	 Assert.assertTrue(employeeRepository.findById(2).isEmpty());                
    }
/*	@Test
    public void testFindByEmail() throws Exception{
	  Employee employee2=new Employee();
    	employee2.setEmployeeId(6);
    	employee2.setEmployeeName("amrutha");
    	employee2.setEmployeeEmail("amrutha@gmail.com");
    	employee2.setEmployeePhone("9550355319");
    	
    	 Mockito.when(employeeRepository.findByEmail("amrutha@gmail.com")).thenReturn(employee2);
    	 assertThat(employeeService.findEmployeeByEmail("amrutha@gmail.com")).isEqualTo(employee2);
    }
	@Test
	public void testUpdateEmployeeById() throws Exception{
		Employee employee2=new Employee();
    	employee2.setEmployeeId(6);
    	employee2.setEmployeeName("amrutha");
    	employee2.setEmployeeEmail("amrutha@gmail.com");
    	employee2.setEmployeePhone("9550355319");
    	
    	  Mockito.when(employeeRepository.save(employee2)).thenReturn(employee2);
    	  Mockito.when(employeeRepository.findByEmail("amrutha@gmail.com")).thenReturn(employee2);        
    	  //findById(6).get()).thenReturn(employee2);
    	  employee2.setEmployeeEmail("marinas@gmail.com");
    	  System.out.println(employee2.getEmployeeEmail());
    	  Mockito.when(employeeRepository.save(employee2)).thenReturn(employee2);
    	  System.out.println(employee2.getEmployeeEmail());
    	  
    	  assertThat(employeeService.findEmployeeByEmail("marinas@gmail.com")).isEqualTo(employee2.getEmployeeEmail());
    	
  
 
	}*/
  
}
