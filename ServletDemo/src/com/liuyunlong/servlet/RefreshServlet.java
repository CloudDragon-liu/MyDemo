package com.liuyunlong.servlet;

import java.io.*;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月3日 下午5:32:23
 */
@WebServlet("/RefreshServlet")
public class RefreshServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		// forward(response, writer);
		this.getServletContext().getRequestDispatcher("/ServletDemo/jsp/login.jsp").forward(request, response);
		
	}

	private void forward(HttpServletResponse response, PrintWriter writer) {
		response.setHeader("refresh", "3;url='/ServletDemo/jsp/login.jsp'");

		writer.write("success 3 second later will forward to other page, if not please click the <a href = ''>url</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
