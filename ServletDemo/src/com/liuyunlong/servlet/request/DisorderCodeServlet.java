package com.liuyunlong.servlet.request;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月4日 上午11:34:02
 */
@WebServlet("/DisorderCodeServlet")
public class DisorderCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// // request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		// username = new String(username.getBytes("ISO8859-1"), "utf-8");
		System.out.println(username);
		response.getWriter().write(username);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
