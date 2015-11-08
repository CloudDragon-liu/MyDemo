package com.liuyunlong.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/** 
* @author  : liuyunlong
* @version ：2015年11月8日 上午9:57:14 
* */
public class JDBCUtil {

	private static String driver = null;

	private static String url = null;

	private static String username = null;

	private static String password = null;

	private static Statement mStatement;

	private static Connection mConnection;

	private static ResultSet mResultSet;

	private static InputStream is;

	static {
		try {
			is = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(is);

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");

			Class.forName(driver);

		} catch (Exception e) {
			System.err.println("jdbc 初始化失败");
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * 创建connection
	 * @return
	 * @throws SQLException
	 * @version 2015年11月8日下午2:25:40
	 */
	private static Connection getConnection() throws SQLException {

		mConnection = DriverManager.getConnection(url, username, password);
		if (null == mConnection) {
			System.err.println("数据库连接失败");
		}

		return mConnection;
	}

	/**
	 * 释放资源
	 * 
	 * @version 2015年11月8日下午2:25:52
	 */
	public static void release() {

		if (mResultSet != null) {
			try {
				mResultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (mStatement != null) {
			try {
				mStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (mConnection != null) {
			try {
				mConnection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mConnection = null;
		}

		if (is != null) {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			is = null;
		}

	}

	/**
	 * 增
	 * @param sql
	 * @return
	 * @version 2015年11月8日上午10:38:54
	 */
	public static int insert(String sql) {
		try {
			getConnection();
			mStatement = mConnection.createStatement();
			int result = mStatement.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			System.err.println(sql);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 删
	 * @param sql
	 * @return
	 * @version 2015年11月8日上午10:39:36
	 */
	public static int delete(String sql) {
		try {
			getConnection();
			mStatement = mConnection.createStatement();
			int result = mStatement.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			System.err.println(sql);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 改
	 * @param sql
	 * @return
	 * @version 2015年11月8日上午10:39:48
	 */
	public static int update(String sql) {
		try {
			getConnection();
			mStatement = mConnection.createStatement();
			int result = mStatement.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			System.err.println(sql);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 查
	 * @param sql
	 * @return
	 * @version 2015年11月8日上午10:39:55
	 */
	public static ResultSet query(String sql) {
		try {
			getConnection();
			mStatement = mConnection.createStatement();
			return mStatement.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println(sql);
			e.printStackTrace();
		}
		return null;
	}
}
