package com.liuyunlong.servlet.cookie;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月4日 下午9:58:25
 */
@WebServlet("/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(0);
		cookie.setPath("/ServletDemo");
		response.addCookie(cookie);
//		response.sendRedirect("/ServletDemo/ShwolastTimeCookieServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
