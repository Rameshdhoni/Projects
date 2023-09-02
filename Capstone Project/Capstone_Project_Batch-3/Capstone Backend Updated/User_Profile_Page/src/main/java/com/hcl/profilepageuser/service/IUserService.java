package com.hcl.profilepageuser.service;

import java.util.List;
import java.util.Optional;

import com.hcl.profilepageuser.dto.UserDTO;
import com.hcl.profilepageuser.entities.User;

public interface IUserService {
	
	
	
	public User Register(User user); // USER REGISTAR
	public String Login(String userName, String userPassword);
	public List<User> getUser(); 
	public User updateUser(Integer userId, User user);//UPDATE USER
	public void deleteUser(Integer id); //DELETE USER
	public Optional<User> searchUsers(String userName);
	public List<User> searchUser(String userName);
	public Optional<User> userDetails(Integer userId);//GET ALL USERS
	
		
	
	
	
}
