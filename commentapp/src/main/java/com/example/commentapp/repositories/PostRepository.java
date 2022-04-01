package com.example.commentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentapp.entities.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {

}
