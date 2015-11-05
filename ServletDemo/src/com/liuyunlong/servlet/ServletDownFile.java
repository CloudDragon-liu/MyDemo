package com.liuyunlong.servlet;

import java.io.*;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyunlong.utils.DownloadUtil;

/**
 * @author liuyunlong
 * @version 2015年11月3日 上午10:39:37
 */
@WebServlet("/ServletDownFile")
public class ServletDownFile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html;charset=UTF-8");
		String path = "/chm/51CTO下载-Apache2.2手册中文版CHM版.chm";
		ServletContext context = this.getServletContext();

		DownloadUtil.download(response, context, path);
	}

	private void download(HttpServletResponse response, ServletContext context, String path) {
		// 两种读取方式 1.直接读取流 2.读取路径后在通过传统方式获取流（可以获取文件名）
		String realPath = context.getRealPath(path);
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
		// 如何文件名包含中文名，则文件名需要经过url编码

		InputStream is = null;
		OutputStream os = null;
		try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
			is = new FileInputStream(realPath);
			os = response.getOutputStream();
			int len = 0;
			byte b[] = new byte[1024];
			while ((len = is.read(b)) > 0) {
				os.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
