package com.liuyunlong.servlet.cookie;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月5日 上午11:02:42
 */
@WebServlet("/GoodDetailServlet")
public class GoodDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("当前书籍为：<br/>");

		// 显示详细信息
		String id = request.getParameter("id");
		Book book = (Book) Db.getAll().get(id);
		writer.print(book.getName());
		// 设置cooike

		Cookie cookie = new Cookie("goodHistory", getCookieValue(id, request));
		cookie.setMaxAge(60 * 60 * 1000);
		cookie.setPath("/ServletDemo");
		response.addCookie(cookie);

	}

	@SuppressWarnings("unchecked")
	private String getCookieValue(String id, HttpServletRequest request) {
		// goodHistory == null
		// goodHistory 231 1 123;
		// goodHistory 234 1 123
		// goodHistory 23 1 123
		String cookieValue = null;
		String goodHistory = null;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; null != cookies && i < cookies.length; i++) {
			if (cookies[i].getName().equals("goodHistory")) {
				goodHistory = cookies[i].getValue();
			}
		}
		if (null == goodHistory) {
			return id;
		}
		// 不能直接用goodHistory.contains(id))，比如21也包含1，需要分割成数组，转成集合，再判断集合中是否包含当前的id
		String[] ids = goodHistory.split("\\,");
		List<String> list = Arrays.asList(ids); // 将数组转成list集合
		@SuppressWarnings("rawtypes")
		LinkedList<String> idList = new LinkedList(list); // 对list进行增删改查性能不好，转成LinkedList
		if (idList.contains(id)) {
			idList.remove(id);
		} else {
			if (idList.size() >= 3) {
				idList.removeLast();
			}
		}
		idList.addFirst(id);
		StringBuffer sb = new StringBuffer();
		for (String bid : idList) {
			sb.append(bid + ",");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// public static void main(String[] args) {
	//
	// LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	// map.put("1", "你");
	// map.put("2", "我");
	// map.put("3", "哈");
	// map.put("4", "是");
	// StringBuffer buffer = new StringBuffer();
	// for (Map.Entry<String, String> entity : map.entrySet()) {
	// buffer.append(entity.getValue() + ",");
	// }
	// String str = buffer.deleteCharAt(buffer.length() - 1).toString();
	// String[] strings = str.split("\\,");
	// String str3 = "是";
	// LinkedList<String> asList = new LinkedList(Arrays.asList(strings));
	// if (asList.contains(str3)) {
	// asList.remove(str3);
	// asList.addFirst(str3);
	// }
	//
	// // List<String> list = Arrays.asList(map);
	// // list.add("");
	// }
}
