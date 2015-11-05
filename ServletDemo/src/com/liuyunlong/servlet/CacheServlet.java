package com.liuyunlong.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月3日 下午8:03:40
 */
@WebServlet("/CacheServlet")
public class CacheServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		// response.setDateHeader("expires", System.currentTimeMillis() + 1000 * 600);
		// System.out.println("inininin");
		// String str = "aaa";

		response.sendRedirect("/ServletDemo/html/login.html");

		// writer.write(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
