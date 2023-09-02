package com.hcl.profilepageuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.profilepageuser.dto.PostDTO;
import com.hcl.profilepageuser.entities.Post;
import com.hcl.profilepageuser.repository.PostRepo;
import com.hcl.profilepageuser.repository.PostRepository;

@Service
public class PostServiceImp implements IPostService
{
	@Autowired
	PostRepo postRepo;
	@Autowired
	PostRepository postRepository;
	public Post newPost(Post post) {
		postRepo.save(post);
		return post;
	}
	
	public List<Post> getPost() {
		return postRepo.findAll();
	}
	 //UPDATE POST
	public Post updatePost(Integer id, Post post) {
		Post post1 = postRepo.findById(id).get();

		post1.setPostName(post.getPostName());
		post1.setDate(post.getDate());
		post1.setImage(post.getImage());

		return postRepo.save(post1);
	}
	//DELETE POST
	public void deletePost(Integer id) {
        postRepository.deleteById(id);
   }
	//SEARCHING THE POST
	public Optional<Post> searchPosts(String userName) {
        Optional<Post> posts = postRepository.findByUserName(userName);
        return posts;
    }

	
	public List<Post> searchPost(String userName) {
        List<Post> post = postRepo.findByUserName(userName);
        return post;
    }
	
	public Optional<Post> postDetails(Integer userId) {
        Optional<Post> post = postRepository.findById(userId);
        return post;
    }
}
