package com.capstone.ams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * 
 * @author ramasrujana.meka@hcl.com
 * 
 */

//pilot model class
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pilotId;
	@NotEmpty(message = "pilot name is mandatory")
	private String pilotName;
	@Min(value = 21, message = "age should be between 21 and 58")
	@Max(value = 58, message = "age should be between 21 and 58")
	private int age;
	@NotEmpty(message = "Gender is mandatory for pilot")
	private String gender;
	@NotBlank(message = "salary is mandatory for pilot")
	private String salary;
	@NotEmpty(message = "mobilenumber is mandatory for pilot")
	private String mobileNumber;
	
	
}
