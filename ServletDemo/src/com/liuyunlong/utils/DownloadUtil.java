package com.liuyunlong.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载工具类
 * 
 * @author : liuyunlong
 * @version ：2015年11月3日 上午11:20:13
 */
public class DownloadUtil {

	/**
	 * 文件下载方法
	 * 通过ServletContext读取对象时有两种方式：
	 * 1. 直接通过读取流；
	 * 2. 先读取文件路径后再用传统方式获取流 第二种方式可以获取文件名，下载时需要显示文件名，故此处用第二种方式 此外如果
	 * 
	 * 另外：文件名中包含中文，则需要经过URLEncoder类进行url编码
	 * 
	 * @param response HttpServletResponse
	 * @param context ServletContext对象
	 * @param path 文件路径
	 * @version 2015年11月3日上午11:33:57
	 */
	public static void download(HttpServletResponse response, ServletContext context, String path) {
		String realPath = context.getRealPath(path);
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
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

}
