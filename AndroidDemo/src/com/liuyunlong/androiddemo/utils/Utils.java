package com.liuyunlong.androiddemo.utils;

import java.util.Calendar;

/** 
* @author  : liuyunlong
* @version ：2015-10-10 下午4:24:24 
* */
public class Utils {

	private static Calendar cal;

	private static String year;

	private static String month;

	private static String day;

	private static String hour;

	private static String minute;

	private static String second;

	/**
	 * 获取当前时间
	 * @return
	 * liuyunlong
	 * 2015-8-11下午9:34:44
	 */
	public static String getDateString() {
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR) + "";
		month = cal.get(Calendar.MONTH) + 1 + "";
		day = cal.get(Calendar.DAY_OF_MONTH) + "";
		hour = cal.get(Calendar.HOUR_OF_DAY) + "";
		minute = cal.get(Calendar.MINUTE) + "";
		second = cal.get(Calendar.SECOND) + "";
		String str = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
		return str;

	}

	/**
	 * 只获取日期
	 * @return
	 * liuyunlong
	 * 2015-8-11下午9:35:00
	 */
	public static String getSimpleDateString() {
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR) + "";
		month = cal.get(Calendar.MONTH) + 1 + "";
		day = cal.get(Calendar.DAY_OF_MONTH) + "";
		String str = year + "-" + month + "-" + day;
		return str;
	}
}
