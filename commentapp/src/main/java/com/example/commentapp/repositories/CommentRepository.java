package com.example.commentapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentapp.entities.Comment;
import com.example.commentapp.entities.Post;


public interface CommentRepository extends JpaRepository<Comment, Integer> {

	List<Comment> findByUserIdAndPostId(Integer userId, Integer postId);

	List<Comment> findByUserId(Integer userId);

	List<Comment> findByPostId(Integer postId);

}
