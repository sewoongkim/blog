package com.cos.blog.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	public static Connection getConnection(){
		try {
			
			
			/*
			 * java:comp/env는 웹어플의 구성된 엔트리와 리소스들이 배치되어있는 부분. 그래서 이것에 접근을 하여 web.xml의
			 * <resource-env-ref>에 설정한 jdbc/mysql과 매핑되는 리소스를 가져온다.
			 * 
			 * 톰캣의 리소스 팩토리를 구성하기 위해 <Context>엘리먼트를 추가해야한다. 
			 * (server.xml 코드 추가할때 서버를 구동하여 context에 프로젝트를 등록하고 리소스 추가하는 과정)
			 */
			
			Context initContext = new InitialContext();
			Context envContext =(Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			System.out.println("DB연결 실패:" + e.getMessage());
		}
		return null;
	}
	
	
	public static void close(Connection conn, PreparedStatement psmt ) {
		try {
			conn.close();
			psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void close(Connection conn, PreparedStatement psmt, ResultSet rs ) {
		try {
			conn.close();
			psmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
