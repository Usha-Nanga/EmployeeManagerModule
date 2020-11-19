package com.tca.time.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name ="EMPLOYEE")
public class Employee {
	

	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePhone;
    
	public Employee() {
		
	}

	public Employee(int employeeId, String employeeName, String employeeEmail,
			String employeePhone) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail + ", employeePhone=" + employeePhone
				+ "]";
	}
	
	
   
	   

}
