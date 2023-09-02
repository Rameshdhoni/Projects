package com.hcl.miniproject.entities;

/*
 * Author: Ramesh
 * class name: admin entity class  
 * purpose:declaring admin instance variable and we can access object anywhere in the projects
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.extern.slf4j.Slf4j;

//ADMIN Entity Class
@Entity
@Slf4j
@Table(name = "Admin_Table")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	private String adminName;
	private String adminPassword;

	public Admin() {
		super();
	}

	public Admin(long adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public long getAdminId() {
		log.info("entity method executing ");
		return adminId;

	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
}