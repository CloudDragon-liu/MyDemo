package com.liuyunlong.db;

import java.util.LinkedHashMap;

import com.liuyunlong.domain.Book;

/**
 * 模拟数据库 
* @author  : liuyunlong
* @version ：2015年11月5日 下午7:36:24 
* */
public class Db {

	private static LinkedHashMap<String, Book> map = new LinkedHashMap();

	static {
		map.put("1", new Book(1, "Java编程", "sun"));
		map.put("2", new Book(2, "JavaScript编程", "sun"));
		map.put("3", new Book(3, "JQuery编程", "sun"));
		map.put("4", new Book(4, "Spring框架", "sun"));
		map.put("5", new Book(5, "MyBatis框架", "sun"));
	}

	public static LinkedHashMap<String, Book> getAll() {
		return map;

	}
}
