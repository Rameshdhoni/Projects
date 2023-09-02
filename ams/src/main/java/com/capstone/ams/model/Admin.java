package com.capstone.ams.model;

/**
 * This is Admin model class and used different annotations for input validations on different input attributes.
 * 
 * @author jakkula.ramesh@hcl.com
 *
 */

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
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
 * @author jakkula.ramesh@hcl.com
 *
 */

//admin model class
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminId;
	@NotEmpty(message = "firstname is mandatory")
	private String firstName;
	@NotEmpty(message = "lastname is mandatory")
	private String lastName;
	@Min(value = 21, message = "age should be between 21 and 58")
	@Max(value = 58, message = "age should be between 21 and 58")
	private int age;
	@NotBlank(message = "gender is mandatory")
	private String gender;
	@Length(min = 10, max = 10, message = "mobileNumber should be exactly 10 numbers")
	private String contactNumber;
	@Email(message = "email is mandatory")
	@NotBlank(message = "email is mandatory")
	private String email;
	@Length(min = 1, max = 10, message = "name should be between 1 to 10 character")
	private String password;

}
