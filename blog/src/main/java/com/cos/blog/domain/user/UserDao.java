package com.cos.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.blog.config.DB;
import com.cos.blog.domain.user.dto.JoinReqDto;

public class UserDao {

	public int save(JoinReqDto dto) {
	
		String sql = "insert Into [user] (username, password, email, address, userRole, createDate) values(?,?,?,?,'USER', getdate()) ";
		Connection conn = DB.getConnection();
		PreparedStatement psmt = null;

		int result = -1;

		try {
			psmt  = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUsername());
			psmt.setString(2, dto.getPassword());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getAddress());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, psmt);
		}
		return result;
		
	}
	
	public void update() {
		
	}
	
	public void usernameCheck() {
		
	}
	
	public void findById() {
		
	}
	
	public int findByUsername(String username) {
		String sql = "select count(*)  cnt from  [user] where username = ? ";
		Connection conn = DB.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, psmt, rs);
		}
		return result;
	}
}
