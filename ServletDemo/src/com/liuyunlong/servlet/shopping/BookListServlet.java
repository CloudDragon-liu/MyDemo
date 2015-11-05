package com.liuyunlong.servlet.shopping;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liuyunlong.db.Db;
import com.liuyunlong.domain.Book;

/**
 * 所有书列表
 * @author liuyunlong
 * @version 2015年11月5日 下午7:32:50
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("本网站有如下商品：<br>");
		LinkedHashMap<String, Book> map = Db.getAll();

		HttpSession session = request.getSession();
		// 手动将session的id放入cookie中，以解决关闭浏览器后，cookie失效导致无法找到session
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		for (Map.Entry<String, Book> entity : map.entrySet()) {
			Book book = entity.getValue();
			// 通过重写URL携带sessio的id防止用户禁用cookie，导致无法找到session,必须要先getSession()
			String url = response.encodeURL("/ServletDemo/BuyBookServlet?id=" + book.getId());
			writer.print(book.getName() + "----" + book.getAuthor() + "<a href='" + url + "' target='_blank'>  购买</a>" + "<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
