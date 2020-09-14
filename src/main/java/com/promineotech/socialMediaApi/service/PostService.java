package com.promineotech.socialMediaApi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.socialMediaApi.entity.Post;
import com.promineotech.socialMediaApi.entity.User;
import com.promineotech.socialMediaApi.repository.PostRepository;
import com.promineotech.socialMediaApi.repository.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Iterable<Post> getAllPosts() {
		return repo.findAll();
	}
	
	public Post getPost(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public Post updatePost(Post post, Long id) {
		Post foundPost = repo.findById(id).orElseThrow();
		if (foundPost == null) {
			throw new RuntimeException("Post not found.");
		}
		foundPost.setContent(post.getContent());
		return repo.save(foundPost);
	}
	
	public Post createPost(Post post, Long userId) {
		User user = userRepo.findById(userId).orElseThrow();
		if (user == null) {
			throw new RuntimeException("User not found.");
		}
		post.setDate(new Date());
		post.setUser(user);
		return repo.save(post);
	}	
}
