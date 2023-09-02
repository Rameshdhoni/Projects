package com.hcl.profilepageuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.profilepageuser.entities.*;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{
	// Post defined method to find password and user name
	Optional<Post> findByUserName(String userName);

	
}
