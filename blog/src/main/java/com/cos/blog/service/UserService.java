package com.cos.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cos.blog.config.DB;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDao;
import com.cos.blog.domain.user.dto.JoinReqDto;
import com.cos.blog.domain.user.dto.LoginReqDto;
import com.cos.blog.domain.user.dto.UpdateReqDto;

public class UserService {

	// 회원가입 
	
	//회원수정
	
	//회원로그인
	
	//회원로그아웃
	
	//아이디증복체크
	
    private UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	// public UserService(UserDao userDao) {
	//	this.userDao = userDao;
	// }
	
	
	public int  회원가입(JoinReqDto dto) {
		// UserDao userDao = new UserDao(); 
		int result = userDao.save(dto);
		return result;
	}
	
	//select * from user where username = ? and password = ? "
	public User 로그인(LoginReqDto dto) {
		
		return null;
	}

	public int 회원수정 (UpdateReqDto dto) {

		return 1;
		
	}

	public int  유저네임중복체크 (String username) {
		int result = userDao.findByUsername(username);
		return result;
		
	}
}
