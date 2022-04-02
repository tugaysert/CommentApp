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
import com.example.commentapp.entities.Post;
import com.example.commentapp.requests.CommentCreateRequest;
import com.example.commentapp.requests.CommentUpdateRequest;
import com.example.commentapp.services.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
	
	private CommentService commentService;
	
	
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}



	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Integer> userId,
			@RequestParam Optional<Integer> postId){
		return commentService.getAllCommentWithParam(userId, postId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest commentRequest) {
		return commentService.createOneComment(commentRequest);
	}

	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable int commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment (@PathVariable int commentId,
			@RequestBody CommentUpdateRequest updateComment ) {
		return commentService.updateOneCommentById(commentId, updateComment);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOnePost(@PathVariable int commentId) {
		 commentService.deleteOneCommentById(commentId);
	}
	
	

}
