package com.example.commentapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentapp.entities.Comment;
import com.example.commentapp.entities.Like;
import com.example.commentapp.entities.Post;
import com.example.commentapp.requests.CommentCreateRequest;
import com.example.commentapp.requests.CommentUpdateRequest;
import com.example.commentapp.requests.LikeCreateRequest;
import com.example.commentapp.services.CommentService;
import com.example.commentapp.services.LikeService;

@CrossOrigin
@RestController
@RequestMapping("/likes")
public class LikeController {
	
	private LikeService likeService;
	
	
	
	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}



	@GetMapping
	public List<Like> getAllLikes(@RequestParam Optional<Integer> userId, 
			@RequestParam Optional<Integer> postId) {
		return likeService.getAllLikesWithParam(userId, postId);
	}
	
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest likeRequest) {
		return likeService.createOneLike(likeRequest);
	}

	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable int likeId) {
		return likeService.getOneLikeById(likeId);
	}
	
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable int likeId) {
		likeService.deleteOneLikeById(likeId);
	}
	
	

}
