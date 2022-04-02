package com.example.commentapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentapp.entities.Comment;
import com.example.commentapp.entities.Like;
import com.example.commentapp.entities.Post;
import com.example.commentapp.entities.User;
import com.example.commentapp.repositories.CommentRepository;
import com.example.commentapp.repositories.LikeRepository;
import com.example.commentapp.requests.CommentCreateRequest;
import com.example.commentapp.requests.CommentUpdateRequest;
import com.example.commentapp.requests.LikeCreateRequest;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	

	public LikeService(LikeRepository likeRepository, UserService userService,
			PostService postService) {
		
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
		}



	public List<Like> getAllLikesWithParam(Optional<Integer> postId, Optional<Integer> userId) {
		
		if(userId.isPresent() && postId.isPresent()) {
			
			return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}
		else if(userId.isPresent()) {
			return likeRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId.get());
		}
		else return likeRepository.findAll();
		
	}



	public Like getOneLikeById(int likeId) {
		
		return likeRepository.findById(likeId).orElse(null);
	}



	public Like createOneLike(LikeCreateRequest likeRequest) {
		User user = userService.getOneUserById(likeRequest.getUserId());
		Post post = postService.getOnePostById(likeRequest.getPostId());
		if(user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(likeRequest.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
			return likeRepository.save(likeToSave);
		}else		
			return null;
	}





	public void deleteOneLikeById(int likeId) {
		likeRepository.deleteById(likeId);
	}
	
	
	
	

}
