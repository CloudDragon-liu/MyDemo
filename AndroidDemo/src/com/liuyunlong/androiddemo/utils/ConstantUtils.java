package com.liuyunlong.androiddemo.utils;

/** 
* @author  : liuyunlong
* @version ：2015-9-11 下午5:06:11 
* */
public class ConstantUtils {

	public static class NUMBER {
		public static final int ZERO = 0;
		public static final int ONE = 1;
		public static final int TWO = 2;
		public static final int THREE = 3;
		public static final int FOUR = 4;
		public static final int FIVE = 5;
		public static final int SIX = 6;
		public static final int SEVEN = 7;
		public static final int EIGHT = 8;
		public static final int NINE = 9;
		public static final int TEN = 10;
	}

	public static class TypeInfo {
		private Integer type;

		private String msg;

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public TypeInfo(Integer type, String msg) {
			this.type = type;
			this.msg = msg;
		}

	}

}
