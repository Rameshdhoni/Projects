package com.capstone.ams.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author jakkula.ramesh@hcl.com
 * @author kurapati.kavyasree@hcl.com
 * 
 */

//hangar model class
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hangar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long hangarId;
	@NotEmpty(message = "hangarName is mandatory")
	private String hangarName;
	@NotEmpty(message = "hangarSize is mandatory")
	private String hangarSize;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "pid")
	private Plane plane;

}
