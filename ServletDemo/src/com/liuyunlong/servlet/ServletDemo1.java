package com.liuyunlong.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * 继承GenericServlet类
 * 
 * @author : liuyunlong
 * @version ：2015年11月1日 上午10:45:12
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getOutputStream().write("ServletDemo1".getBytes());
	}

}
