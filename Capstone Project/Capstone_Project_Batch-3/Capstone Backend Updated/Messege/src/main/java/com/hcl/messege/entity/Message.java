package com.hcl.messege.entity;
/*
 * @Author: Ramesh
 * Date: 17-01-2023
 */

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="msg_tbl")
//creating a table with name msg_tbl
public class Message {
	//@Id represents a primary key of the table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	//from User must not be null
	@Column(nullable = false)
	private String fromUser;
	//toUser must not be null
	@Column(nullable = false)
	private String toUser;
	private LocalDate date;
	

	

}
