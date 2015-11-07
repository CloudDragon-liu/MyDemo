package com.liuyunlong.dao;

import com.liuyunlong.domain.User;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午11:10:43 
* */
public interface UserDao {

	/**
	 * 增加用户
	 * @param user
	 * @version 2015年11月7日上午11:06:45
	 */
	public abstract void add(User user);

	/**
	 * 查询用户
	 * @param user
	 * @return
	 * @version 2015年11月7日上午11:06:37
	 */
	public abstract User select(User user);

}