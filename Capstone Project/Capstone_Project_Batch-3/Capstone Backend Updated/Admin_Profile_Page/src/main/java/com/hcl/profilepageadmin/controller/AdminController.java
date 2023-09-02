package com.hcl.profilepageadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.profilepageadmin.dto.AdminDTO;
import com.hcl.profilepageadmin.entities.Admin;
import com.hcl.profilepageadmin.service.IAdminService;

/*
 * @Author:Ramesh
 * Date: 16-01-2023
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	// ADMIN Registration

	@PostMapping("/register")  
	public String Register(@RequestBody Admin admin)
	{
		adminService.Register(admin);
		return "Admin Added Successfully";
	}

	@PostMapping("/login")
	public String login(@RequestParam String adminName, @RequestParam String adminPassword) {
		String result = adminService.Login(adminName, adminPassword);
		if (result.equals("valid Admin")) {
			return adminName;
		} else {
			return "Invalid";
		}
	}

	@PutMapping("/update/{id}")
	public String updateAdmin(@PathVariable(value = "id") Integer id, @RequestBody AdminDTO adminDTO) {
		adminService.updateAdmin(id, adminDTO);
		return "Updated successfully";
	}

	@GetMapping("/admins")
	public List<Admin> getAdmin() {
		return adminService.getAdmin();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable(value = "id") Integer id) {
		adminService.deleteAdmin(id);
		return "Deleted successfully";
	}
}
