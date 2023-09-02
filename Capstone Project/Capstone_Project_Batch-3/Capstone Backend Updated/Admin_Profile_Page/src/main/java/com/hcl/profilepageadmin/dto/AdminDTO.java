package com.hcl.profilepageadmin.dto;



import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

/*
 * @Author: Ramesh
 * Date: 16-01-2023
 */


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class AdminDTO{

	
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private String adminPhone;
	
}
