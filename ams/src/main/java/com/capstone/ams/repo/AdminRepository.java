package com.capstone.ams.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capstone.ams.model.Admin;
/**
*
* 
* @author jakkula.ramesh@hcl.com
*
*/

//AdminRepsitory
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	
	   //getting admin emailId
		public Admin getByEmail(String email);
		//public Admin findByadminName(String adminName);


		
	
}
