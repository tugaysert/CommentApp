package com.example.commentapp.requests;

import lombok.Data;

@Data
public class PostUpdateRequest {
	
	//post'un update edecegimiz alanlari belli
	//gidip'de userId'sini update etmeyecegiz
	
	String title;
	String text;

}
