package com.liuyunlong.servlet.session;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月5日 下午4:11:26
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		// request.getSession(false); // 只获取，不创建，比如用在查看购物车，没必要创建session，只需要获取，当然创建也可以但是有点性能影响（若此时没有购买商品时无需创建session）
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/ServletDemo");
		cookie.setMaxAge(60 * 30);
		response.addCookie(cookie);
		session.setAttribute("name", "洗衣机");
		// session.invalidate(); // 销毁session
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
