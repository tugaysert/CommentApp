package com.example.commentapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
	
	int id; //gecici, kontrol
	String text;
	String title;
	int userId;

}
