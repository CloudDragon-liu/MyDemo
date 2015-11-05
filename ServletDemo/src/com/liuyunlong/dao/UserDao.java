package com.liuyunlong.dao;

import com.liuyunlong.utils.PropertyUtil;

/**
 * @author : liuyunlong
 * @version ：2015年11月2日 下午4:59:25
 */
public class UserDao {

	public void update() {

		System.out.println(PropertyUtil.readResource("db.properties").getProperty("username"));
	}

	public void select() {
		System.out.println(PropertyUtil.readResource("db.properties").getProperty("password"));

	}
}
