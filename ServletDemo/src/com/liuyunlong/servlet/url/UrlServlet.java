package com.liuyunlong.servlet.url;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月4日 下午4:56:25
 */
@WebServlet("/UrlServlet")
public class UrlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(""); // 转发
		response.sendRedirect(""); // 重定向
		this.getServletContext().getRealPath(""); // 获取文件绝对地址
		this.getServletContext().getResourceAsStream(""); // 获取文件流
		// 超链接
		// from表单

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
