package com.liuyunlong.servlet.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.liuyunlong.db.Db;
import com.liuyunlong.domain.Book;

/**
 * 购买书
 * @author liuyunlong
 * @version 2015年11月5日 下午7:48:13
 */
@WebServlet("/BuyBookServlet")
public class BuyBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		Book book = Db.getAll().get(id);

		HttpSession session = request.getSession(false);
		if (null != session) {
			List bookList = (List) session.getAttribute("book-list");
			if (null == bookList) {
				bookList = new ArrayList();
				session.setAttribute("book-list", bookList);
			}
			bookList.add(book);
		}

		// response.sendRedirect(request.getContextPath() + "/ListCartServlet");
		// 通过重写URL携带sessio的id防止用户禁用cookie，导致无法找到session
		String url = response.encodeRedirectURL(request.getContextPath() + "/ListCartServlet");
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
