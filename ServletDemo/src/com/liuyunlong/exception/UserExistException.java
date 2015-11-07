package com.liuyunlong.exception;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午11:20:18 
* */
public class UserExistException extends Exception {

	/**
	 * liuyunlong
	 * 20152015年11月7日上午11:20:21
	 */
	private static final long serialVersionUID = 1L;

	public UserExistException() {
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
