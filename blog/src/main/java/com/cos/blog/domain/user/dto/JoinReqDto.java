package com.cos.blog.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class JoinReqDto {
	private String username;
	private String password;
	private String email;
	private String address;
	
}
