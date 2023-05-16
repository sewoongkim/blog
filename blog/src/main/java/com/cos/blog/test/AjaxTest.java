package com.cos.blog.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class AjaxTest extends HttpServlet {

	public AjaxTest() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.print("ok");
		out.flush();

		// TODO Auto-generated method stub
		//		super.doGet(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		out.println("ok");
		out.flush();
		
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
	}
}