package com.hcl.profilepageadmin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

/*
 * @Author: Ramesh
 * Date: 16-01-2023
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name="admin")
public class Admin{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private String adminPhone;
	
}
