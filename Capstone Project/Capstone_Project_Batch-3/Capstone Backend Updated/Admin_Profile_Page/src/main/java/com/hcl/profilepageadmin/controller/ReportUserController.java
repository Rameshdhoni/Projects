package com.hcl.profilepageadmin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.profilepageadmin.entities.ReportUser;
import com.hcl.profilepageadmin.service.IReportUserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController 
@RequestMapping("/report")   

public class ReportUserController {
	
	@Autowired  
	IReportUserService userService;
	
	@PostMapping("/insert")  
	public String addReportUser(@RequestBody ReportUser user)
	{
		userService.Register(user);
		return "User Added Successfully";
	}
	
	@GetMapping("/users")     
	public List<ReportUser> getUsers()
	{
		return userService.getUser();
	}

	@DeleteMapping("/delete/{id}")    
	public String deleteOwner(@PathVariable (value="id") Integer id)
	{
		userService.deleteUser(id);
		return "Deleted successfully";
	}
	

}
