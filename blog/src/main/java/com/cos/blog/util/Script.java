package com.cos.blog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	

	public static void back( HttpServletResponse response, String msg) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<SCRIPT>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</SCRIPT>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
