package com.liuyunlong.juit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.liuyunlong.domain.User;
import com.liuyunlong.utils.JDBCUtil;

/** 
* @author  : liuyunlong
* @version ：2015年11月8日 上午9:53:41 
* */
public class TestDemo {

	@Test
	public void testSelect() {

		String sql = "select * from user";
		ResultSet resultSet = JDBCUtil.query(sql);
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setNickname(resultSet.getString("nickname"));
				user.setIcon(resultSet.getString("icon"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setBirthday(resultSet.getDate("birthday"));
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release();
		}

	}

	@Test
	public void testAdd() {
		try {
			String sql = "insert into user (id, username,password,type,birthday) values(6,'liuuyi','147',1,'1980-10-12')";
			int result = JDBCUtil.insert(sql);
			if (result > 0) {
				System.out.println("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release();
		}
	}

	@Test
	public void testModify() {
		try {
			String sql = "update user set username='women的' where id = 6";
			int result = JDBCUtil.update(sql);
			if (result > 0) {
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.release();
		}
	}

	@Test
	public void testDelete() {
		try {
			String sql = "delete from user where id = 6";
			int result = JDBCUtil.delete(sql);
			if (result > 0) {
				System.out.println("success");
			}

		} catch (Exception e) {
		} finally {
			JDBCUtil.release();

		}
	}
}
