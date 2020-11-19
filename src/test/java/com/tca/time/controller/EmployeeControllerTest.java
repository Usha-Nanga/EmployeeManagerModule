package com.tca.time.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tca.time.model.Employee;
import com.tca.time.services.EmployeeService;
@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
class EmployeeControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private EmployeeService employeeService;

	 @Test
	   public void testNewEmployee() throws Exception{
		  String URI = "/api/v2/CreateEmployee";
		  Employee employee=new Employee();
		  employee.setEmployeeId(1);
		  employee.setEmployeeName("ammu");
		  employee.setEmployeePhone("9701531212");
		  employee.setEmployeeEmail("amrutha@gmail.com");
		  String jsonInput = this.converttoJson(employee);

		  Mockito.when(employeeService.createEmployee(Mockito.any(Employee.class))).thenReturn(employee);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
		  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	 
	 }
	 private String converttoJson(Object manager) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(manager);
	    }
	 
	 @Test
	 public void testDeleteEmployee()
	 {
		 //Employee employee=
	 }
	
}
