package com.hcl.profilepageuser.dto;

/*
 * @Author: Ramesh
 * Date: 16-01-2023
 */
import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//this is message dto
public class Message {

	private int id;
	private String content;
	private String fromUser;

	private String toUser;
	private LocalDate date;

}
