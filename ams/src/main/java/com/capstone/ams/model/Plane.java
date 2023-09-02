package com.capstone.ams.model;

/**
 * 
 * 
 * @author manneusha.sri@hcl.com
 * 
 */


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


//plane model class
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plane {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long planeId;
	@NotEmpty(message = "plane name should not be empty")
	private String planeName;
	@NotEmpty(message = "Plane source field is mandatory")
	private String planeSource;
	@NotEmpty(message = "Plane destination is mandatory")
	private String planeDestination;
	@Min(value = 100, message = "min 100 passengers should be required")
	@Max(value = 500, message = "passengers should not exced 500")
	private int planeCapacity;
	@NotEmpty(message = "Plane speed should be in mph or kmph")
	private String planeSpeed;
	@NotEmpty(message = "Plane weight field is mandatory and should be in tons")
	private String planeWeight;
	
}
