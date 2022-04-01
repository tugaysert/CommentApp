package com.example.commentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentapp.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
