package com.liuyunlong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承HttpServlet
 * 
 * @author liuyunlong
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDemo2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getOutputStream().write("servletDemo2".getBytes());
		response.setStatus(302);
		response.setHeader("location", "/ServletDemo/html/login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
