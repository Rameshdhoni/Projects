package com.hcl.profilepageadmin.entities;

import java.time.LocalDateTime;
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
@Table(name="post_approve")
public class AdminPostApproval {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String postName;
	private LocalDateTime date;
	private String userName;
	private String image;
	
}

