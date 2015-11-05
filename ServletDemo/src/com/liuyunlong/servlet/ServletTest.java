package com.liuyunlong.servlet;

import java.io.*;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyunlong.dao.UserDao;

/**
 * 复习用的
 * 
 * @author liuyunlong
 * @version 2015年11月3日 上午9:12:02
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int i;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		// threadSave();

		// String string = servletConfig();

		// servletContextShareData();
		getGlobalDataAndDispatcher(request, response);

		// readResourceInSrc();
		// readResourceInConfig();
		// UserDao userDao = new UserDao();
		// userDao.update();
		// writer.write("");
	}

	private void readResourceInConfig() throws IOException {
		InputStream inStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/liuyunlong/config/db.properties");
		Properties properties = new Properties();
		properties.load(inStream);
		System.out.println(properties.getProperty("username"));
	}

	private void readResourceInSrc() throws IOException {
		InputStream inStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(inStream);
		System.out.println(properties.getProperty("username"));
	}

	private void getGlobalDataAndDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String string = context.getInitParameter("data3");
		context.setAttribute("dispatcher", string);
		context.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	private void servletContextShareData() {
		ServletContext context = this.getServletContext();
		context.setAttribute("hah", "gogo");
	}

	private String servletConfig() {
		ServletConfig config = this.getServletConfig();
		String string = config.getInitParameter("nihao");
		return string;
	}

	private void threadSave() {
		synchronized (this) {
			try {
				i++;
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
