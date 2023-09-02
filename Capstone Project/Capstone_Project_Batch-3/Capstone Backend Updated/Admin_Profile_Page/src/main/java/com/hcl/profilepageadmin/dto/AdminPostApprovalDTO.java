package com.hcl.profilepageadmin.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;




@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class AdminPostApprovalDTO {
	
	
	private int id;
	private String postName;
	private LocalDateTime date;
	private String userName;
	private String image;
	
}

