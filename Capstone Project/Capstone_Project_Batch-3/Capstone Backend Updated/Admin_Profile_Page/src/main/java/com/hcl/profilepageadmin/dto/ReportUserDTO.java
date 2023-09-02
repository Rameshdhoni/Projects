package com.hcl.profilepageadmin.dto;



import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class ReportUserDTO{
	
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userPhone;
	
}
