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

@Entity 

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name="reporteduser")
public class ReportUser{
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userPhone;
	
}
