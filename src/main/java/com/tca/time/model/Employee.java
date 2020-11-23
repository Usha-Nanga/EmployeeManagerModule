package com.tca.time.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity 
@Table(name ="EMPLOYEE")
public class Employee {
    @Column
	@ApiModelProperty(notes="ID of the Employee",name="employeeId",required=true,value="test id")
	private int employeeId;
    @Column
    @ApiModelProperty(notes="Name of the Employee",name="employeeName",required=true,value="test name")
	private String employeeName;
    @Column
    @ApiModelProperty(notes="Email of the Employee",name="employeeEmail",required=true,value="test email")
 	private String employeeEmail;
    @Column
    @ApiModelProperty(notes="Phone Number of the Employee",name="employeePhone",required=true,value="test number")
	private String employeePhone;
    
	public Employee() {
		
	}
	@Id
	@Column(name = "employee_id", nullable = false)
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name = "employee_name", nullable = false)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Column(name = "employee_email", nullable = false)
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	@Column(name = "employee_phone", nullable = false)
	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

//	@Override
//	public String toString() {
//		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail + ", employeePhone=" + employeePhone
//				+ "]";
//	}
//	
	
   
	   

}
