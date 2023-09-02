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
import org.springframework.web.bind.annotation.RestController;

import com.hcl.profilepageuser.dto.PostDTO;
import com.hcl.profilepageuser.entities.*;
import com.hcl.profilepageuser.service.IPostService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/post")
public class PostController {  // REST CONTROLLER CLASS
	
	@Autowired // INJECTING OBJECT FOR POSTSERVICEIMP USING AUTOWIRED ANNOTATION
	IPostService postService;
	//Post login
	// Post CRUD Operations on creating a Post,display all post,delete and update post by id
	@PostMapping("/new")
	public String newPost(@RequestBody Post post) {
		postService.newPost(post);
		return"Post Added Successfully!";
	}
	
	@GetMapping("/posts")    
    public List<Post> getPost()
    {
        return postService.getPost();
    }
	
    @PutMapping("/update/{id}")  
    public String updatePost(@PathVariable (value="id") Integer id,@RequestBody Post post)
    {
        postService.updatePost(id,post);
        return "Post Updated Successfully";
    }
    
    @DeleteMapping("/delete/{id}")   
    public String deleteUser(@PathVariable (value="id") Integer id)
    {
        postService.deletePost(id);
        return "deleted successfully";
    }
    
    @GetMapping("/searchs/{userName}")
    public Optional<Post> searchPosts(@PathVariable (value="userName")String userName){
        return postService.searchPosts(userName);
    }
    
	@GetMapping("/search/{userName}")
    public List<Post> searchPost(@PathVariable (value="userName")String userName){
        return postService.searchPost(userName);
    }
	
	@GetMapping("/detail/{id}") 
	public Optional<Post> postDetail(@PathVariable (value="id") Integer userId)
	{
		return postService.postDetails(userId);
		
	}

}

