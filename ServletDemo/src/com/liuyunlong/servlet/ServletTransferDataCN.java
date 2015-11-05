package com.liuyunlong.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuyunlong
 * @version 2015年11月2日 下午9:08:03
 */
@WebServlet("/ServletTransferDataCN")
public class ServletTransferDataCN extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// outPutStreamOut(response);

		// response.getOutputStream().write((1 + "").getBytes());
		// printWriter(response);

	}

	/**
	 * servlet字符流输出中文需要设置response的编码同时要告诉浏览器以什么编码方式打开
	 * 
	 * @param response
	 * @throws IOException
	 * @version 2015年11月3日上午10:33:58
	 */
	private void printWriter(HttpServletResponse response) throws IOException {
		String data = "中国";
		response.setCharacterEncoding("utf-8"); // 修改response的编码方式，
		response.setContentType("text/html;charset=utf-8"); // 除此之外还要告诉浏览器以utf-8打开
		PrintWriter writer = response.getWriter();
		writer.write(data);
	}

	/**
	 * outPutStream输出
	 * 
	 * @param response
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @version 2015年11月2日下午9:20:16
	 */
	private void outPutStreamOut(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		String data = "中国";

		response.getOutputStream().write(data.getBytes("utf-8")); // 数据以字节流输出，的编码格式为utf-8
		response.setContentType("text/html;charset=UTF-8"); // 告诉浏览器用utf-8解码数据
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
