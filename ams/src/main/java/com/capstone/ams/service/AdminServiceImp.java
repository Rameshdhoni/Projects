package com.capstone.ams.service;

/**
 * This is used for writing admin service implementations class business logics with proper validations

 * 
 * @author jakkula.ramesh@hcl.com
 *        
 */

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capstone.ams.exception.AdminAlreadyExistsException;

import com.capstone.ams.model.Admin;

import com.capstone.ams.repo.AdminRepository;

import lombok.extern.log4j.Log4j2;

//AdminService implementation class 
@Log4j2
@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	AdminRepository adminRepo; // injecting adminrepository into adminserviceimp

	// admin registration
	@Override
	public String registration(Admin admin) {

		if (adminRepo.findById(admin.getAdminId()).isPresent()) {
			try {
				throw new AdminAlreadyExistsException(); // exceptionhandling for admin

			} catch (AdminAlreadyExistsException e) {

				return "admin details already exists";
			}

		} else {
			if (admin != null) {
				adminRepo.save(admin);
			}
		}
		if (adminRepo.save(admin).getAdminId() > 0) {
			log.info("registration done Successfully");
			return "registration done Successfully";
		}
		log.info("registration failed");

		return "registration Failed";

	}

	// admin login
	@Override
	public Admin login(String email) {
		log.info("calling login method with email as a argument");
		return adminRepo.getByEmail(email);
	}

}