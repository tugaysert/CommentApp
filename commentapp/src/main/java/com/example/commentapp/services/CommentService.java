package com.example.commentapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentapp.entities.Comment;
import com.example.commentapp.entities.Post;
import com.example.commentapp.entities.User;
import com.example.commentapp.repositories.CommentRepository;
import com.example.commentapp.requests.CommentCreateRequest;
import com.example.commentapp.requests.CommentUpdateRequest;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	

	public CommentService(CommentRepository commentRepository, UserService userService,
			PostService postService) {
		
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
		}



	public List<Comment> getAllCommentWithParam(Optional<Integer> postId, Optional<Integer> userId) {
		
		if(userId.isPresent() && postId.isPresent()) {
			
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}
		else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}
		else return commentRepository.findAll();
		
	}



	public Comment getOneCommentById(int commentId) {
		
		return commentRepository.findById(commentId).orElse(null);
	}


	//atacagimiz comment'in, commentRequest'i kullanarak gercekten varolan bir
	//postId ve userId'ye bagliligini teyit edecegiz.
	//bunun icin burada user ve post service'lerine ihtiyacimiz var
	public Comment createOneComment(CommentCreateRequest commentRequest) {
		
		User user = userService.getOneUserById(commentRequest.getUserId());
		Post post = postService.getOnePostById(commentRequest.getPostId());
		
		if(user !=null && post !=null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(commentRequest.getId());
			commentToSave.setText(commentRequest.getText());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			return commentRepository.save(commentToSave);
		}
			
		else return null;
	}



	public Comment updateOneCommentById(int commentId, CommentUpdateRequest updateComment) {
		
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(updateComment.getText());
			return commentRepository.save(commentToUpdate);
		}
		
		else return null;
	}



	public void deleteOneCommentById(int commentId) {
		
		commentRepository.deleteById(commentId);
		
	}
	
	
	
	

}
