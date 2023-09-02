package com.hcl.profilepageadmin.dto;
/*
 * @Author: Ramesh
 * Date: 16-01-2023
 */
import java.time.LocalDate;

import javax.persistence.Column;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @Author: Ramesh
 * Date: 18-01-2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//this is message dto
public class Message {
	//@Id represents a primary key of the table
	
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
