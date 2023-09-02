package com.hcl.profilepageuser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hcl.profilepageuser.dto.UserDTO;
import com.hcl.profilepageuser.entities.Post;
import com.hcl.profilepageuser.entities.User;
import com.hcl.profilepageuser.service.IPostService;
import com.hcl.profilepageuser.service.IUserService;
@CrossOrigin(origins="http://localhost:3000")
@RestController  
@RequestMapping("/user")
public class UserController {// REST CONTROLLER CLASS
	
	@Autowired  // INJECTING OBJECT FOR USER SERVICEIMP USING AUTOWIRED ANNOTATION
	IUserService userService;
	// Admin CRUD Operations on creating a User,display all users,delete and update user by id
	
	@PostMapping("/register")  
	public String Register(@RequestBody User user)
	{
		userService.Register(user);
		return "User Added Successfully";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String userPassword) {
		userService.Login(userName, userPassword);
		return "Login SucussFully ";
    }
	
	@GetMapping("/users") 
	public List<User> getUser()
	{
		return userService.getUser();
	}
	
	@PutMapping("/update/{id}")  
	public String updateUser(@PathVariable (value="id") Integer userId,@RequestBody User user)
	{
		userService.updateUser(userId,user);
		return "Updated successfully";
	}
	
	@GetMapping("/detail/{id}")   
	public Optional<User> userDetail(@PathVariable (value="id") Integer userId)
	{
		return userService.userDetails(userId);
		
	}
	
	@DeleteMapping("/delete/{id}")    
	public String deleteUser(@PathVariable (value="id") Integer id)
	{
		userService.deleteUser(id);
		return "Deleted successfully";
	}
	
	@GetMapping("/searchs/{userName}")
    public Optional<User> searchUsers(@PathVariable (value="userName")String userName){
        return userService.searchUsers(userName);
    }
	
	@GetMapping("/search/{userName}")
    public List<User> searchUser(@PathVariable (value="userName")String userName){
        return userService.searchUser(userName);
    }
	

}
