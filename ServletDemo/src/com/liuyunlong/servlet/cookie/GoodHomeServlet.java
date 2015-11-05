package com.liuyunlong.servlet.cookie;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示首页
 * @author liuyunlong
 * @version 2015年11月5日 上午11:03:35
 */
@WebServlet("/GoodHomeServlet")
public class GoodHomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		// 输出所有书籍
		writer.write("所有书籍如下：<br />");

		Map<String, Book> map = Db.getAll();
		for (Map.Entry<String, Book> entity : map.entrySet()) {
			Book book = entity.getValue();
			writer.print("<a href='/ServletDemo/GoodDetailServlet?id=" + book.getId() + "' target='_blank'>" + book.getName() + " </a><br/>");
		}

		// 显示已看过的书籍
		writer.write("您已浏览过：<br />");
		Cookie[] cookies = request.getCookies();
		for (int i = 0; null != cookies && i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
				String id = cookies[i].getValue();
				Book book = map.get(id);
				writer.write(book.getName() + " " + book.getAuthor());
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

class Db {

	private static Map<String, Book> map = new LinkedHashMap();

	static {
		map.put("1", new Book(1, "Java编程", "sun"));
		map.put("2", new Book(2, "JavaScrip编程", "sun"));
		map.put("3", new Book(3, "Spring框架", "sun"));
		map.put("4", new Book(4, "MyBatis框架", "sun"));
	}

	public static Map getAll() {
		return map;
	}
}

class Book {

	private Integer id;

	private String name;

	private String author;

	public Book(Integer id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Book() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
