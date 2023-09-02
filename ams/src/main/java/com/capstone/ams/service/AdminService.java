package com.capstone.ams.service;



/**
 * This is used for writing admin methods definations here.
 * 
 * @author jakkula.ramesh@hcl.com
 *        
 */

import com.capstone.ams.model.Admin;

//AdminService Interface 
public interface AdminService {

	// admin registration
	public String registration(Admin admin); 

	// admin login
	public Admin login(String email);

}
