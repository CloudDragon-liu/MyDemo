package com.liuyunlong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuyunlong
 * @version 2015年11月2日 下午1:55:20
 */
public class ServletConfi extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		// 得到指定的
		String username = this.getServletConfig().getInitParameter("username");

		// 得到所有的
		Enumeration<String> enumeration = this.getServletConfig().getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			String value = this.getServletConfig().getInitParameter(string);
			System.out.println(value);
		}

		writer.write(username);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
