package com.example.commentapp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentapp.entities.Post;
import com.example.commentapp.entities.User;
import com.example.commentapp.repositories.PostRepository;
import com.example.commentapp.requests.PostCreateRequest;
import com.example.commentapp.requests.PostUpdateRequest;

@Transactional
@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPosts(Optional<Integer> userId) {
		if(userId.isPresent())
		return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}

	public Post getOnePostById(int postId) {
		
		return postRepository.findById(postId).orElse(null);
	}
	//Service
	public Post createOnePost(PostCreateRequest newPostRequest) {
		//Servis bunu alıp şak diye repo'ya kaydetmiyecek.
		//Önce bir validasyon yapmamız lazım.
		//post oluşturmak istiyorum ama gelen userId database'de var mı?
		//buna bakmak icin de UserService'e baglanmamiz gerekecek.
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user == null) return null;
		
		//daha sonra converter atilabilir, ama simdilik:
		Post postToSave = new Post();
		postToSave.setId(newPostRequest.getId());
		postToSave.setText(newPostRequest.getText());
		postToSave.setTitle(newPostRequest.getTitle());
		
		//user icin validasyon yaptığımız, emin olduğumuz user'i kullanıcaz
		postToSave.setUser(user);
		
		return postRepository.save(postToSave);
	}

	public Post updateOnePostById(int postId, PostUpdateRequest updatePost) {
		
		Optional<Post> post = postRepository.findById(postId);
		
		if(post.isPresent()) {
			Post postToUpdate = post.get();
			postToUpdate.setText(updatePost.getText());
			postToUpdate.setTitle(updatePost.getTitle());
			postRepository.save(postToUpdate);
			return postToUpdate;
		}
		return null;
	}

	public void deleteOnePostById(int postId) {
		postRepository.deleteById(postId);
		
	}

}
