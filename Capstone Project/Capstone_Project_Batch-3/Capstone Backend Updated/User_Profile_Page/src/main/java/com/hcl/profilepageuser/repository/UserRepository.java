package com.hcl.profilepageuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.profilepageuser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	// user defined method to find password and user name
	Optional<User> findByUserName(String userName);
}
