package com.tca.time.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="MANAGER")
public class Manager {
	
	private int managerId;	
	private String managerName;
	private String managerEmail;
	private String managerPhone;
    
	public Manager()
	{
		
	}

	public Manager(int managerId, String managerName, String managerEmail,
			String managerPhone) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerPhone = managerPhone;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName="
				+ managerName + ", managerEmail=" + managerEmail + ", managerPhone="
				+ managerPhone + "]";
	}
	
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