package com.example.commentapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentapp.entities.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUserId(Integer userId);

}
