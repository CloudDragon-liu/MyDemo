package com.liuyunlong.servlet.shopping;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liuyunlong.domain.Book;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月5日 下午8:04:17
 */
@WebServlet("/ListCartServlet")
public class ListCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(false);
		if (null == session) {
			writer.write("您未购买任何书籍");
			return;
		}
		writer.write("购物车商品如下：<br>");
		List<Book> bookList = (List) session.getAttribute("book-list");
		for (Book book : bookList) {
			writer.write(book.getName() + "<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
