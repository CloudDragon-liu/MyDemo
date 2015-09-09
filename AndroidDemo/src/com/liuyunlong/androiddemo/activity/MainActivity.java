package com.liuyunlong.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liuyunlong.androiddemo.R;

/**
 * 之界面
 * @author liuyunlong
 *2015-9-9 上午9:59:45
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.flagment_btn:
			Intent intent = new Intent(this, FragmentActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
