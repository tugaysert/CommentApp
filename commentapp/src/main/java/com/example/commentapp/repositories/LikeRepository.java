package com.example.commentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentapp.entities.Like;


public interface LikeRepository extends JpaRepository<Like, Integer> {

}
