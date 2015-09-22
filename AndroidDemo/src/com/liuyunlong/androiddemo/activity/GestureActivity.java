package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/** 
 * 手势识别
* @author  : liuyunlong
* @version ：2015-9-21 下午9:05:33 
* */
public class GestureActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.getsture);
	}
}
