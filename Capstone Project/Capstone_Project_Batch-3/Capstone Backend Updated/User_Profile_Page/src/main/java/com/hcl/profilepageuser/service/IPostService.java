package com.hcl.profilepageuser.service;

import java.util.List;
import java.util.Optional;

import com.hcl.profilepageuser.dto.PostDTO;
import com.hcl.profilepageuser.entities.Post;




public interface IPostService 
{
	public Post newPost(Post post);
	public List<Post> getPost();
	public Post updatePost(Integer id, Post post);//UPDATE POST
	public void deletePost(Integer id);    // DELETE POST
	public Optional<Post> searchPosts(String userName);//SEARCHING POST
	public List<Post> searchPost(String userName);
	public Optional<Post> postDetails(Integer userId);
}
	
