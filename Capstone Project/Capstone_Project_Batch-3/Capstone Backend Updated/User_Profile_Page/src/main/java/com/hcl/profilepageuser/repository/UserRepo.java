package com.hcl.profilepageuser.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.profilepageuser.entities.User;

@Repository     
public interface UserRepo extends JpaRepository<User,Integer>{

	Object findByUserNameAndUserPassword(String userName, String userPassword);

	
	List<User> findByUserName(String userName);
	List<User> findByUserId(Integer userId);
	

}
