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
		public static final int ELEVEN = 11;
		public static final int TWELVE = 12;
		public static final int THIRTEEN = 13;
		public static final int FOURTEEN = 14;
		public static final int FIFTEEN = 15;
		public static final int SIXTEEN = 16;
		public static final int SEVENTEEN = 17;
		public static final int EIGHTEEN = 18;
		public static final int NINETEEN = 19;
		public static final int TWENTY = 20;
	}

	/**
	 * 对话框类型
	 * @author liuyunlong
	 *2015-9-22 下午3:20:21
	 */
	public static class DIALOG_TYPE {
		public static final int NORMAL = 0;
		public static final int WITH_CHECKBOX = 1;
		public static final int WITH_EDITTEXT = 2;
		public static final int WITH_PROGRESSBAR = 3;
		public static final int WITH_CHECKBOX_PROGRESSBAR = 4;
		public static final int WITH_EDITTEXT_PROGRESSBAR = 5;
	}

	public static class FILE_DIR {
		public static final String FILE_NAME_JAVA_IO = "javaio.txt";
		public static final String DIR = "files";
	}

	/**
	 * handler消息
	 * @author liuyunlong
	 *2015-9-16 下午3:14:14
	 */
	public static class MSG_HANDLER {
		/**进入主应用*/
		public static final int ENTER_MAIN_MENU = 0;
	}

	/**
	 * 测试
	 * @author liuyunlong
	 *2015-9-16 下午3:13:11
	 */
	public static class OTHERS extends TypeInfo {
		public OTHERS(Integer type, String msg) {
			super(type, msg);
		}

		public static final OTHERS FIRST = new OTHERS(0, "XX");

	}

	/**通话记录类型*/
	public static class Dial extends TypeInfo {

		public Dial(Integer type, String msg) {
			super(type, msg);
		}

		public static final Dial OUT_GOING = new Dial(2, "拨出");

		public static final Dial INCOMING = new Dial(1, "拨入");

		public static final Dial MISSED = new Dial(3, "未接");
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
