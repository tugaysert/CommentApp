package com.example.commentapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentapp.entities.User;
import com.example.commentapp.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	
	 private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable int userId) {
		
		return userService.getOneUserById(userId);
	}
	
	@PutMapping("/{userId}") 
	public User updateOneUser(@PathVariable int userId,
			@RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}	
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable int userId) {
		
		userService.deleteById(userId);
	}
	

}
