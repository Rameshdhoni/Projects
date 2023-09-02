package com.capstone.ams.controller;

/**
 * This is Admincontroller class


 * 
 * @author jakkula.ramesh@hcl.com
 *        
 * 
 *
 */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.ams.exception.AdminNotFoundException;
import com.capstone.ams.model.Admin;
import com.capstone.ams.service.AdminService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

     //registration details
	// used @Valid and Global Exception for handling admin registration properly
	@PostMapping("/registration")
	public String Register(@Valid @RequestBody Admin admin) {
		adminService.registration(admin);
		return "Admin Successfully registred";
	}

	/*
	 * public ResponseEntity<String> registration(@Valid @RequestBody Admin admin,
	 * BindingResult result) { log.info("Registration is in progress.."); if
	 * (result.hasErrors()) { return new
	 * ResponseEntity<>(result.getAllErrors().toString(), HttpStatus.BAD_REQUEST); }
	 * String s = adminService.registration(admin); if
	 * (s.contains("Successfully registred")) { return new ResponseEntity<>(s,
	 * HttpStatus.CREATED); } return new ResponseEntity<>(s,
	 * HttpStatus.BAD_REQUEST); }
	 */

	@PostMapping("/login")

	public ResponseEntity<String> loginByPath(@RequestBody Admin admin) {
		try {
			log.info("Login is in progress..");

			Admin resultMember = adminService.login(admin.getEmail());
			if (resultMember != null)
				if (resultMember.getPassword().equals(admin.getPassword())) {
					log.info("Admin Login is success.");
					return new ResponseEntity<>("Success", HttpStatus.OK);
				}
			log.info("Login is failed.");
			return new ResponseEntity<>("Email/Password is incorrect.", HttpStatus.FORBIDDEN);
		} catch (AdminNotFoundException e) { // exceptionhandling for adminnotfound
			throw new IllegalStateException();
		}
	}

}
