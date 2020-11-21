package com.tca.time.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
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
import com.tca.time.model.Manager;
import com.tca.time.services.ManagerService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ManagerController.class)
public class ManagerControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private ManagerService managerService;
	
	 @Test
	   public void testNewManager() throws Exception{
		  String URI = "/api/v2/CreateManager";
		  Manager manager=new Manager();
		  manager.setManagerId(2);
		  manager.setManagerName("RAJU");
		  manager.setManagerEmail("chiku@gmail.com");
		  manager.setManagerPhone("08512518301");
		  String jsonInput = this.converttoJson(manager);

		  Mockito.when(managerService.createManager(Mockito.any(Manager.class))).thenReturn(manager);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
		  MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	 }
	 
	 @Test
	 public void testDeleteManagerById() throws Exception{
		 String URI = "/api/v2/Manager/{id}";
		  Manager manager=new Manager();
	    	manager.setManagerId(1);
	    	manager.setManagerName("MARINA");
	    	manager.setManagerEmail("s@gmail.com");
	    	manager.setManagerPhone("08512");
	    	
	    	managerService.deleteManager(manager.getManagerId());
	 }
	 @Test
	    public void testUpdateManagerById() throws Exception{
	    	 String URI= "/api/v2/Manager/{id}";
	    	 Manager manager=new Manager();
		    	manager.setManagerId(1);
		    	manager.setManagerName("MARINA");
		    	manager.setManagerEmail("marinas@gmail.com");
		    	manager.setManagerPhone("08512");
		    	 String jsonInput = this.converttoJson(manager);
		    		Mockito.when(managerService.updateManager(Mockito.any(), Mockito.any())).thenReturn(manager);
			    	 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 3).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
			                 .andReturn();
			         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
			         String jsonOutput = mockHttpServletResponse.getContentAsString();

			         assertThat(jsonInput).isEqualTo(jsonOutput);  	 
	    }
	    
	    @Test
	    public void testGetAllManagers() throws Exception{
	    	
	       String URI= "/api/v2/Manager";
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
	    	
	    	List<Manager> managerlist=new ArrayList<>();
	    	managerlist.add(manager1);
	    	managerlist.add(manager2);
	    	
	    	String jsonInput = this.converttoJson(managerlist);
	    	Mockito.when(managerService.getAllManager()).thenReturn(managerlist);
	    	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	  
	    }
	 

	  /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object manager) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(manager);
    }

}
