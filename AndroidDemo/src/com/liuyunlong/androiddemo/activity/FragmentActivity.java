package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author liuyunlong
 * @date 2015-9-8 下午11:34:41
 * @version 1.0
 */
public class FragmentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	/**
	 * 
	 * @author liuyunlong
	 * @data 2015-9-8下午11:52:16
	 */
	private void initView() {

		System.out.println("nihao");
	}
}
