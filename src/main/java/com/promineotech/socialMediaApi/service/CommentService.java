package com.promineotech.socialMediaApi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.socialMediaApi.entity.Comment;
import com.promineotech.socialMediaApi.entity.Post;
import com.promineotech.socialMediaApi.entity.User;
import com.promineotech.socialMediaApi.repository.CommentRepository;
import com.promineotech.socialMediaApi.repository.PostRepository;
import com.promineotech.socialMediaApi.repository.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Comment createComment(Comment comment, Long userId, Long postId) {
		User user = userRepo.findById(userId).orElseThrow();
		Post post = postRepo.findById(postId).orElseThrow();
		if (user == null || post == null) {
			throw new RuntimeException("User or Post does not exist.");
		}
		comment.setDate(new Date());
		comment.setUser(user);
		comment.setPost(post);
		return repo.save(comment);
	}
	
	public void deleteComment(Long commentId) {
		repo.deleteById(commentId);
	}

}
