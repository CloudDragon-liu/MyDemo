package com.liuyunlong.androiddemo.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/** 
* @author  : liuyunlong
* @version ：2015-9-14 下午8:21:30 
* */
public class Logger {

	public static void logIn(String string) {

		Log.i("liuyunlong", string);

	}

	public static void logErr(String string) {

		Log.e("liuyunlong", string);

	}

	public static void showToast(Context context, String string) {

		Toast.makeText(context, string, Toast.LENGTH_SHORT).show();

	}
}
