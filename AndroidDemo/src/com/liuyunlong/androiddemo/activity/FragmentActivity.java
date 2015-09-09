package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Fragment
 * @author liuyunlong
 * @date 2015-9-8 下午11:34:41
 * @version 1.0
 */
public class FragmentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment);
		initView();
	}

	/**
	 * 
	 * @author liuyunlong
	 * @data 2015-9-8下午11:52:16
	 */
	private void initView() {

	}
}
