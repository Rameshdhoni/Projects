package com.hcl.profilepageuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.profilepageuser.dto.UserDTO;
import com.hcl.profilepageuser.entities.User;
import com.hcl.profilepageuser.exception.UserNotFoundException;
import com.hcl.profilepageuser.repository.UserRepo;
import com.hcl.profilepageuser.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserRepository userRepository;
	
	//to add the data 
	public User Register(User user) {
		return userRepo.save(user);
	}
		
	public String Login(String userName, String userPassword) {
	       List<User> user1 = userRepo.findAll();
	        int counter = 0;
	        for(User user : user1) {
	            if(user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
	               return "User successfully logged in";
	            }
	        }
	        if(counter == 0) {
	            return "Invalid credentials";
	        }
	        else {UserNotFoundException err = new UserNotFoundException("UserNotFoundException");
	           throw err;
	        }
	   }
		
	//to retrieve the data
	public List<User> getUser() {
		return userRepo.findAll();
	}
	
	//to update the data in database
	public User updateUser(Integer userId, User user) {
		User user1 = userRepo.findById(userId).get();

		user1.setUserName(user.getUserName());
		user1.setUserEmail(user.getUserEmail());
		user1.setUserPhone(user.getUserPhone());
		user1.setUserPassword(user.getUserPassword());

		return userRepo.save(user1);

	}
	
	//to delete the data from database
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);

	}
	
	// fetch user by username
	public Optional<User> searchUsers(String userName) {
	      Optional<User> users = userRepository.findByUserName(userName);
	      return users;
	}
	
	// fetch list of users by username	
	public List<User> searchUser(String userName) {
	       List<User> users = userRepo.findByUserName(userName);
	       return users;
    }
	
	//fetch user details
	public Optional<User> userDetails(Integer userId) {
	       Optional<User> users = userRepo.findById(userId);
	       return users;
	}
		

}
