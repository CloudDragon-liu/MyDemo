package com.liuyunlong.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午11:23:57 
* */
public class Md5 {
	public static String md5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(string.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return string;

	}
}
