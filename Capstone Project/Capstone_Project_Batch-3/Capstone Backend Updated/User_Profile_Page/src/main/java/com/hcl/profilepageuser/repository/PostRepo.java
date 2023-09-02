package com.hcl.profilepageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hcl.profilepageuser.entities.Post;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{

	// Post defined method to find password and user name
	List<Post> findByUserName(String userName);
}


