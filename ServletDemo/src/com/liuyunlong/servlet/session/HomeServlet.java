package com.liuyunlong.servlet.session;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月5日 下午5:23:41
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getSession();

		String buyUrl = response.encodeURL("/ServletDemo/BuyServlet"); // encodeURL方法后面会自动跟上session的id
		String payUrl = response.encodeURL("/ServletDemo/PayServlet"); // encodeURL方法后面会自动跟上session的id

		PrintWriter writer = response.getWriter();
		writer.write("<a href='" + buyUrl + "'>购买</a>");
		writer.write("<a href='" + payUrl + "'>结帐</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
