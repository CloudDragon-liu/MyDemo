package com.liuyunlong.servlet.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.liuyunlong.domain.User;

/**
 * 
 * @author liuyunlong
 * @version 2015年11月4日 上午9:13:18
 */
@WebServlet("/NormalRequestMethodsServlet")
public class NormalRequestMethodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// someRequestMethod(request);
		// getDataFromClient(request);
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getDataFromClient(HttpServletRequest request) {
		// 客户端向服务器端带数据的两种方式
		// 1 . 超链接后面：/servletDemo/login.do?name=liuyunlong
		// 2. 通过表单
		// 获取客户端数据方式
		// 1 getParameter
		System.out.println(request.getParameter("username"));
		// 2 getParameterNames
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();
			String value = request.getParameter(string);
			System.out.println(value);
		}
		// 3 getParameterValues
		String[] values = request.getParameterValues("username");
		if (null != values && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				System.out.println(values[i]);
			}
		}
		// 4 getParameterMap
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap); // map集合填充bean
			// BeanUtils.copyProperties(dest, orig); // bean的拷贝
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void someRequestMethod(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr()); // 获取客户机的IP
		System.out.println(request.getRemoteHost()); // 完整主机名
		System.out.println(request.getRemotePort()); // 获取端口

		System.out.println(request.getHeader("")); // 返回一个string
		System.out.println(request.getHeaders("")); // 返回一个枚举类
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
