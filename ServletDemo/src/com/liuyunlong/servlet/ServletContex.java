package com.liuyunlong.servlet;

import java.io.*;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyunlong.dao.UserDao;
import com.liuyunlong.utils.PropertyUtil;

/**
 * servletContext对象在实际开发中的应用
 * 
 * @author liuyunlong
 * @version 2015年11月2日 下午2:41:01
 */
@WebServlet("/ServletContext")
public class ServletContex extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		// 1. 数据共享给另外一个Servlet
		String data = "数据共享-liuyunlong";
		ServletContext context = this.getServletContext();
		context.setAttribute("name", data);

		// getWebData(context);

		// dispatcher(request, response, data, context);

		// readResource(writer, context);
		// readResourceRealpath(writer, context);

		// readResourceByClassLoader();
		// String path = "/WEB-INF/classes/db.properties";
		// Properties properties = PropertyUtil.readResource(context, path);
	}

	private void readResourceByClassLoader() throws IOException {
	}

	/**
	 * 获取资源的绝对路径再用传统的方式： 可以获取的文件名称
	 * 
	 * @param writer
	 * @param context
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @version 2015年11月2日下午4:49:54
	 */
	private void readResourceRealpath(PrintWriter writer, ServletContext context) throws FileNotFoundException, IOException {
		String realPath = context.getRealPath("/WEB-INF/classes/db.properties");
		System.out.println(realPath);
		FileInputStream stream = new FileInputStream(realPath);
		Properties properties = new Properties();
		properties.load(stream);
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(username + " " + password);
		writer.write(username + " " + password);
	}

	private void readResource(PrintWriter writer, ServletContext context) throws IOException {
		// 4. 读取资源文件
		InputStream stream = context.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(stream);
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(username + " " + password);
		writer.write(username + " " + password);
	}

	private void getWebData(ServletContext context) {
		// 2. 获取整个web应用的初始化数据（<context-param>标签定义的）
		String str = (String) context.getInitParameter("data3");
		System.out.println(str);
	}

	private void dispatcher(HttpServletRequest request, HttpServletResponse response, String data, ServletContext context) throws ServletException, IOException {
		// 3. 通过ServletContext对象实现转发（servlet为产生数据，不适合想浏览器页面输出数据，最好转发给jsp）
		context.setAttribute("dispatcher", data); // 通过servletContext向jsp带数据，不推荐使用；
		RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
