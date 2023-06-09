package com.cos.blog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.domain.user.dto.JoinReqDto;
import com.cos.blog.domain.user.dto.LoginReqDto;
import com.cos.blog.service.UserService;
import com.cos.blog.util.Script;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		UserService userService = new UserService();
		
		if (cmd.equals("loginForm")) {
			response.sendRedirect("user/loginForm.jsp");
		} else if (cmd.equals("login")) {
			// 서비스 호출 
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			LoginReqDto dto =  new LoginReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			userService.로그인(dto);
		} else if (cmd.equals("joinForm")) {
			response.sendRedirect("user/joinForm.jsp");
		} else if (cmd.equals("join")) {
			
			String username  = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			JoinReqDto dto = new JoinReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			dto.setEmail(email);
			dto.setAddress(address);
			System.out.println("회원가입" + dto);
			int result = userService.회원가입(dto);
			
			if(result == 1 ){
				response.sendRedirect("index.jsp");
				System.out.println("RS2" + result);
			} else {
				Script.back(response, "회원가입 실패");
			}
		} else if (cmd.equals("usernameCheck")) {
			BufferedReader br = request.getReader();
			String username = br.readLine();
			System.out.println(username);
			int result = userService.유저네임중복체크(username);
			System.out.println(" 유저네임중복체크" + username);
			System.out.println(" 유저네임중복체크" + result);
			PrintWriter out = response.getWriter();
			if (result == 1) {
				out.write("ok");
			} else {
				out.write("fail");
			}
			out.flush();
		}
	}	
}
