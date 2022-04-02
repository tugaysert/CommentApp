package com.example.commentapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.commentapp.entities.Like;


public interface LikeRepository extends JpaRepository<Like, Integer> {
	
	List<Like> findByUserIdAndPostId(Integer userId, Integer postId);

	List<Like> findByUserId(Integer userId);

	List<Like> findByPostId(Integer postId);

}
