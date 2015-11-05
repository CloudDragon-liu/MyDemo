package com.liuyunlong.servlet.cookie;

import java.io.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie实现打印上次访问时间
 * @author liuyunlong
 * @version 2015年11月4日 下午9:23:40
 */
@WebServlet("/ShwolastTimeCookieServlet")
public class ShwolastTimeCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("<a href='/ServletDemo/DeleteCookieServlet'>clean cookie</a><br/>您上次访问的时间是：");
		// 获取cookies数组
		Cookie[] cookies = request.getCookies();
		for (int i = 0; null != cookies && i < cookies.length; i++) {
			if (cookies[i].getName().equals("lastAccessTime")) {
				long time = Long.parseLong(cookies[i].getValue());
				Date date = new Date(time);
				writer.write(date.toLocaleString());
			}
		}
		// 更新cookie值
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(3600); // 设置cookie的有效期
		cookie.setPath("/ServletDemo"); // 设置cookie的有效路径，即在访问那些serlvet是带上cookie
		response.addCookie(cookie);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
