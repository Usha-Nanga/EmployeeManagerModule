package com.tca.time.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name ="MANAGER")
public class Manager {
	@Column
	@ApiModelProperty(notes="Phone Number of the Manager",name="managerId",required=true,value="test id")
	private int managerId;	
	@Column
	@ApiModelProperty(notes="Phone Number of the Manager",name="managerName",required=true,value="test name")
	private String managerName;
	@Column
	@ApiModelProperty(notes="Phone Number of the Manager",name="managerEmail",required=true,value="test email")
	private String managerEmail;
	@Column
	@ApiModelProperty(notes="Phone Number of the Manager",name="managerPhone",required=true,value="test number")
	private String managerPhone;
    
	public Manager()
	{
		
	}
//
	public Manager(int managerId, String managerName, String managerEmail,
			String managerPhone) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerPhone = managerPhone;
	}

//	@Override
//	public String toString() {
//		return "Manager [managerId=" + managerId + ", managerName="
//				+ managerName + ", managerEmail=" + managerEmail + ", managerPhone="
//				+ managerPhone + "]";
//	}
	
	@Id
	@Column(name = "manager_id", nullable = false)
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Column(name = "manager_name", nullable = false)
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Column(name = "manager_email", nullable = false)
	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	@Column(name = "manager_phone", nullable = false)
	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

		

}