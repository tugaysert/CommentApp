package com.example.commentapp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
	
	int id;
	int userId;
	int postId;

}
