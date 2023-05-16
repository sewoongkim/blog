package com.cos.blog.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//localhost:8080/blog/test

@WebServlet("/test")
public class ApiServerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApiServerTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/plain; charset=utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setContentType("application/json; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕1</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String food = "";
		String method = "";
		
		String mime = request.getContentType();
		System.out.println(mime);
		request.setCharacterEncoding("UTF-8");
		
		if(mime.equals("application/json")) {
			BufferedReader br = request.getReader();
			String input;
			StringBuffer buffer = new StringBuffer();
			while((input = br.readLine()) !=null) {
				buffer.append(input);
				System.out.println(input);
			}
			System.out.println(buffer.toString());
		} else {
			food = request.getParameter("food");
			method = request.getParameter("method");
			System.out.println(food);
			System.out.println(method);
		}
			
		
		
//		int  result =1;
//		
//		PrintWriter out = response.getWriter();
//		if (result==1) {
//			out.println("{\"food\":\"" + food + ",\"method\":\"" + method +"\"}");
//		
//		} else {
//			out.println("{\"error\":\"fail\"}");
//		}
//		
//		out.println(result);
//		out.flush();
		
		response.setContentType("text/plain; charset=utf-8");
		response.setContentType("text/html; charset=utf-8");
//		response.sendRedirect("index.jsp");
		

	}

}
