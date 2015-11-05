package com.liuyunlong.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.liuyunlong.dao.UserDao;

/**
 * 读取资源文件工具类
 * 
 * @author : liuyunlong
 * @version ：2015年11月2日 下午7:18:36
 */
public class PropertyUtil {

	private static Properties properties = new Properties();

	static {
	}

	/**
	 * 通过类加载器读取资源文件，通过定位文件的路径加载可以实时更新加载资源文件的内容
	 * 
	 * @param path 如果文件在src目录 path = db.properties（文件名）
	 * @return
	 * @version 2015年11月2日下午7:51:04
	 */
	public static Properties readResource(String path) {
		try {
			String url = UserDao.class.getClassLoader().getResource(path).getPath();
			FileInputStream stream = new FileInputStream(url);
			properties.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;

	}

	/**
	 * 通过ServletContext对象读取资源文件
	 * 
	 * @param context
	 * @param path src ： /WEB-INF/classes/db.properties config : /WEB-INF/classes/com.liuyunlong/config/db.properties
	 * @return
	 * @version 2015年11月2日下午7:53:58
	 */
	public static Properties readResource(ServletContext context, String path) {
		try {
			InputStream stream = context.getResourceAsStream(path);
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
