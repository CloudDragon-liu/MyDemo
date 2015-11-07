package com.liuyunlong.service.impl;

import com.liuyunlong.dao.UserDao;
import com.liuyunlong.dao.impl.UserDaoImpl;
import com.liuyunlong.domain.User;
import com.liuyunlong.exception.UserExistException;
import com.liuyunlong.utils.Md5;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午11:12:48 
* */
public class UserServiceImpl {

	private UserDao userDao = new UserDaoImpl();

	public void register(User user) throws UserExistException {
		User user2 = userDao.select(user);
		if (null != user2) {
			throw new UserExistException(); // 用户已存在，给web层抛出编译时的异常，提醒处理异常
		} else {
			user.setPassword(Md5.md5(user.getPassword()));
			userDao.add(user);
		}
	}

	public User login(User user) {
		String password = Md5.md5(user.getPassword());
		user.setPassword(password);
		return userDao.select(user);
	}

}
