package com.example.commentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
