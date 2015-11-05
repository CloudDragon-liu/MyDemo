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
 * @version 2015年11月4日 下午2:32:32
 */
@WebServlet("/RequestDispatchServlet")
public class RequestDispatchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/jsp/head.jsp").include(request, response);
		String data = "<a href='/ServletDemo/SafeChainServlet'>管理</a>";
		response.getWriter().write(data);
		// request.setAttribute("data", data);
		// request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		request.getRequestDispatcher("/jsp/foot.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
