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
 * @version 2015年11月4日 下午5:12:47
 */
@WebServlet("/SafeChainServlet")
public class SafeChainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String header = request.getHeader("referer");
		if (null == header || !header.startsWith("http://localhost:9080/")) {
			response.sendRedirect("/ServletDemo/jsp/login.jsp");
			return;
		}
		writer.write("大家好！！！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
