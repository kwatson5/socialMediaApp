package com.promineotech.socialMediaApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.socialMediaApi.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
