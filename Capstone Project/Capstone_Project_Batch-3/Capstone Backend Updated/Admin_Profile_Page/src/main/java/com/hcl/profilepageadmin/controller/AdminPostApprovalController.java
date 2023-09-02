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

import com.hcl.profilepageadmin.entities.AdminPostApproval;
import com.hcl.profilepageadmin.service.IAdminPostApprovalService;

@CrossOrigin(origins="http://localhost:3000")
@RestController 
@RequestMapping("/approve")
public class AdminPostApprovalController {
	
	@Autowired  
	IAdminPostApprovalService adminPostApprovalService;
	
	@PostMapping("/insert")  
	public String addPost(@RequestBody AdminPostApproval task)
	{
		adminPostApprovalService.addPost(task);
		return "Post Added Successfully";
	}
	
	@GetMapping("/posts")
	public List<AdminPostApproval> getPost()
	{
		return adminPostApprovalService.getPost();
	}
	
	@GetMapping("/posts/{id}")  
	public AdminPostApproval getPostbyId(@PathVariable(value="id") Integer id)
	{
		return adminPostApprovalService.getPostById(id);
	}
	
	@DeleteMapping("/delete/{id}") 
	public String deleteVehicle(@PathVariable (value="id") Integer id)
	{
		adminPostApprovalService.deletePost(id);
		return "Deleted successfully";
	}

}
