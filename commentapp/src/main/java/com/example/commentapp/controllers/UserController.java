package com.example.commentapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentapp.entities.User;
import com.example.commentapp.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable int userId) {
		//bu id bizim database'de olmayabilir.
		//optional bir sey donuyor
		//custom exception eklenecek.
		return userRepository.findById(userId).orElse(null);
	}
	
	@PutMapping("/{userId}") 
	public User updateOneUser(@PathVariable int userId,
			@RequestBody User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}
		//custom exception gelecek
		else return null;
	}	
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable int userId) {
		
		userRepository.deleteById(userId);
	}
	

}
