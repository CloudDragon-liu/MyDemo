package com.liuyunlong.androiddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@SuppressLint("ShowToast")
	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.flagment_btn:
			Toast.makeText(this, "哈哈", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}
