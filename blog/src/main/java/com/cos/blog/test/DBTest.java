package com.cos.blog.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.cos.blog.config.DB;

public class DBTest {
	
	@Test
	public void 디비연결() {
		Connection conn = DB.getConnection();
		assertNotNull(conn);
		System.out.println("1111");
		
	}

}
